package kz.bejiihiu.game;

import kz.bejiihiu.game.auth.UserManager;
import kz.bejiihiu.game.story.IStory;
import kz.bejiihiu.game.story.Story;
import kz.bejiihiu.game.tournament.Tournament;
import kz.bejiihiu.game.battle.Battle;
import kz.bejiihiu.game.payment.PaymentProcessor;
import kz.bejiihiu.game.skills.Skills;
import java.util.Scanner;

public class Game {
    private final IStory story;
    private final UserManager userManager;
    private final Tournament tournament;
    private final Battle battle;
    private final PaymentProcessor paymentProcessor;
    private final Scanner scanner;
    private final Skills skills;

    public Game() {
        this.story = new Story();
        this.userManager = new UserManager();
        this.tournament = new Tournament();
        this.battle = new Battle();
        this.paymentProcessor = new PaymentProcessor();
        this.scanner = new Scanner(System.in);
        this.skills = new Skills(30, 30, 30);
    }

    public void start() {
        story.displayPrologue();
        story.displayTransition("Пробуждение");
        System.out.println("\n" + ANSIColors.GREEN + "Добро пожаловать в Тайное Сообщество Игрового Клуба." + ANSIColors.RESET);
        System.out.println(ANSIColors.CYAN + "Выберите действие:" + ANSIColors.RESET);
        System.out.println(ANSIColors.CYAN + "1. Регистрация" + ANSIColors.RESET);
        System.out.println(ANSIColors.CYAN + "2. Авторизация" + ANSIColors.RESET);
        int choice = scanner.nextInt();

        if (choice == 1) {
            userManager.registerUser();
            if (userManager.authorizeUser()) {
                System.out.println(ANSIColors.RED + "Не удалось пройти авторизацию. Судьба оборвалась на раннем этапе." + ANSIColors.RESET);
                return;
            }
        } else if (choice == 2) {
            if (userManager.authorizeUser()) {
                System.out.println(ANSIColors.RED + "Не удалось пройти авторизацию. Врата закрыты для вас." + ANSIColors.RESET);
                return;
            }
        } else {
            System.out.println(ANSIColors.RED + "Некорректный выбор. Судьба требует ясности, программа завершена." + ANSIColors.RESET);
            return;
        }

        System.out.print(ANSIColors.CYAN + "Выберите количество часов для участия в ритуале битвы (2, 4, 5): " + ANSIColors.RESET);
        int hours = scanner.nextInt();
        if (hours != 2 && hours != 4 && hours != 5) {
            System.out.println(ANSIColors.RED + "Неверное количество часов. Ритуал не может быть проведен. Попробуйте снова." + ANSIColors.RESET);
            return;
        }
        paymentProcessor.processPayment(hours);

        story.displayTransition("Испытание: Турнир");
        System.out.print(ANSIColors.CYAN + "Желаете принять участие в турнире испытаний? (да/нет): " + ANSIColors.RESET);
        String participate = scanner.next();
        if (participate.equalsIgnoreCase("да")) {
            System.out.println(ANSIColors.GREEN + "Вы выбрали участвовать в Турнире Судьбы." + ANSIColors.RESET);
            System.out.println(ANSIColors.CYAN + "Выберите игру, ставшую ареной для испытаний вашего духа:" + ANSIColors.RESET);
            System.out.println(ANSIColors.CYAN + "1. DOTA 2" + ANSIColors.RESET);
            System.out.println(ANSIColors.CYAN + "2. Counter-Strike" + ANSIColors.RESET);
            System.out.println(ANSIColors.CYAN + "3. League of Legends" + ANSIColors.RESET);
            int gameChoice = scanner.nextInt();
            tournament.determineWinner(gameChoice);
        } else {
            System.out.println(ANSIColors.YELLOW + "Вы решили не участвовать в турнире, выбирая иной путь сопротивления." + ANSIColors.RESET);
        }

        story.displayTransition("Сражение: Путь Героя");
        battle.startBattle(skills);

        System.out.println("\n" + ANSIColors.PURPLE + "=== Конец главы ===" + ANSIColors.RESET);
        System.out.println(ANSIColors.YELLOW + "Ваш путь в этом испытании завершён, но битва за свободу продолжается..." + ANSIColors.RESET);
    }
}
