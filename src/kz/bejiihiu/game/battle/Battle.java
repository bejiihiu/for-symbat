package kz.bejiihiu.game.battle;

import kz.bejiihiu.game.ANSIColors;
import kz.bejiihiu.game.skills.Skills;
import java.util.Random;
import java.util.Scanner;

public class Battle {
    private final Random random;
    private final Scanner scanner;

    public Battle() {
        random = new Random();
        scanner = new Scanner(System.in);
    }

    public void startBattle(Skills skills) {
        System.out.println(ANSIColors.CYAN + "Добро пожаловать в арену судьбы. Здесь каждое ваше решение будет испытанием вашей воли." + ANSIColors.RESET);
        boolean continueBattle = true;

        while (continueBattle) {
            System.out.println("\n" + ANSIColors.BLUE + "--- Режим героя ---" + ANSIColors.RESET);
            System.out.println(ANSIColors.YELLOW + "Ваши текущие навыки: " + skills + ANSIColors.RESET);
            System.out.println(ANSIColors.YELLOW + "Перед вами открывается эпическая арена, наполненная древними тайнами и смертельными опасностями." + ANSIColors.RESET);
            System.out.println(ANSIColors.CYAN + "Выберите действие:" + ANSIColors.RESET);
            System.out.println(ANSIColors.CYAN + "1. Атаковать врага с отвагой." + ANSIColors.RESET);
            System.out.println(ANSIColors.CYAN + "2. Скрыться в тенях, чтобы подготовить удар." + ANSIColors.RESET);
            System.out.println(ANSIColors.CYAN + "3. Вступить в переговоры, чтобы избежать кровопролития." + ANSIColors.RESET);
            System.out.println(ANSIColors.CYAN + "4. Исследовать руины в поисках древних артефактов." + ANSIColors.RESET);
            System.out.println(ANSIColors.CYAN + "5. Исследовать загадочный сигнал, манящий из глубин ночи." + ANSIColors.RESET);
            System.out.println(ANSIColors.CYAN + "6. Завершить сражение и узнать исход битвы." + ANSIColors.RESET);

            System.out.print(ANSIColors.CYAN + "Ваш выбор (1-6): " + ANSIColors.RESET);
            String action = scanner.next();

            switch (action) {
                case "1" -> handleAttack(skills);
                case "2" -> handleStealth(skills);
                case "3" -> handleNegotiation(skills);
                case "4" -> handleExploration(skills);
                case "5" -> handleMysterySignal(skills);
                case "6" -> {
                    System.out.println(ANSIColors.YELLOW + "Вы завершаете сражение, готовясь к финальному испытанию." + ANSIColors.RESET);
                    determineBattleOutcome(skills);
                    continueBattle = false;
                }
                default -> System.out.println(ANSIColors.RED + "Неверный выбор. Судьба требует ясного решения." + ANSIColors.RESET);
            }

            if (continueBattle) {
                randomEvent(skills);
                System.out.print(ANSIColors.CYAN + "Желаете продолжить путь героя? (да/нет): " + ANSIColors.RESET);
                String cont = scanner.next();
                if (!cont.equalsIgnoreCase("да")) {
                    System.out.println(ANSIColors.YELLOW + "Вы завершаете текущий этап битвы." + ANSIColors.RESET);
                    determineBattleOutcome(skills);
                    continueBattle = false;
                }
            }
        }
    }

    private void handleAttack(Skills skills) {
        System.out.println(ANSIColors.GREEN + "Вы бросаетесь в атаку, вооруженные не только мечом, но и верой в победу." + ANSIColors.RESET);
        if (skills.shooting > 50) {
            System.out.println(ANSIColors.GREEN + "Ваш точный выстрел поражает врага, словно молния рассеивает тьму." + ANSIColors.RESET);
        } else {
            System.out.println(ANSIColors.RED + "Ваш удар промахивается, и враг готовится к контратаке." + ANSIColors.RESET);
            if (random.nextBoolean()) {
                System.out.println(ANSIColors.GREEN + "В последний момент вам удается переломить ход боя, несмотря на ранение." + ANSIColors.RESET);
            } else {
                System.out.println(ANSIColors.RED + "Враг слишком силен, и вам приходится отступить, чтобы сберечь силы для следующего удара." + ANSIColors.RESET);
            }
        }
    }

    private void handleStealth(Skills skills) {
        System.out.println(ANSIColors.GREEN + "Вы растворяетесь в тенях, полагаясь на свою скрытность и инстинкты." + ANSIColors.RESET);
        if (skills.stealth > 50) {
            System.out.println(ANSIColors.GREEN + "Благодаря мастерству маскировки, вы остаетесь незамеченным, как ветер в ночи." + ANSIColors.RESET);
        } else {
            System.out.println(ANSIColors.RED + "Ваше укрытие обнаружено, и враг начинает преследование." + ANSIColors.RESET);
            if (skills.shooting > 40) {
                System.out.println(ANSIColors.GREEN + "Вы молниеносно отвечаете ударом, выбивая врага из тени." + ANSIColors.RESET);
            } else {
                System.out.println(ANSIColors.RED + "Преследование оборачивается ловушкой, и вы вынуждены отступить." + ANSIColors.RESET);
            }
        }
    }

    private void handleNegotiation(Skills skills) {
        System.out.println(ANSIColors.GREEN + "Вы решаете попробовать найти выход без насилия, вступая в переговоры с врагом." + ANSIColors.RESET);
        if (skills.tactics > 50) {
            System.out.println(ANSIColors.GREEN + "Ваша мудрость и дипломатия приводят к временной передышке в бою." + ANSIColors.RESET);
        } else {
            System.out.println(ANSIColors.RED + "Слова не находят отклика, и враг переходит к атаке." + ANSIColors.RESET);
            if (skills.shooting > 40) {
                System.out.println(ANSIColors.GREEN + "В критический момент вы отвечаете огнем, вынуждая врага отступить." + ANSIColors.RESET);
            } else {
                System.out.println(ANSIColors.RED + "Переговоры проваливаются, и битва достигает апогея." + ANSIColors.RESET);
            }
        }
    }

    private void handleExploration(Skills skills) {
        System.out.println(ANSIColors.GREEN + "Вы отправляетесь исследовать руины, надеясь найти артефакты древних цивилизаций." + ANSIColors.RESET);
        System.out.println(ANSIColors.YELLOW + "Среди пыли забвения вы находите реликвии, пробуждающие силу предков." + ANSIColors.RESET);
        skills.shooting += 5;
        skills.stealth += 5;
        skills.tactics += 5;
        System.out.println(ANSIColors.GREEN + "Ваши навыки улучшаются от мистической энергии древних знаний." + ANSIColors.RESET);
    }

    private void handleMysterySignal(Skills skills) {
        System.out.println(ANSIColors.GREEN + "Загадочный сигнал манит вас вглубь ночи. Вы следуете за ним, полными решимости узнать истину." + ANSIColors.RESET);
        System.out.println(ANSIColors.YELLOW + "Преодолевая лабиринт теней, вы находите заброшенную поляну, где время замирает." + ANSIColors.RESET);
        System.out.println(ANSIColors.YELLOW + "Перед вами предстают древние руны, наполненные тайнами былых эпох." + ANSIColors.RESET);
        System.out.println(ANSIColors.CYAN + "Выберите:" + ANSIColors.RESET);
        System.out.println(ANSIColors.CYAN + "1. Исследовать руны и постичь их древнюю мудрость." + ANSIColors.RESET);
        System.out.println(ANSIColors.CYAN + "2. Отступить, опасаясь необъяснимой силы." + ANSIColors.RESET);
        System.out.print(ANSIColors.CYAN + "Ваш выбор (1-2): " + ANSIColors.RESET);
        String subChoice = scanner.next();
        if (subChoice.equals("1")) {
            System.out.println(ANSIColors.GREEN + "Вы внимаете голосу древних, и знания предков вливаются в вас." + ANSIColors.RESET);
            skills.tactics += 7;
            skills.stealth += 5;
        } else {
            System.out.println(ANSIColors.RED + "Вы решаете не трогать таинственные руны, оставляя их загадки нерешенными." + ANSIColors.RESET);
        }
    }

    private void randomEvent(Skills skills) {
        int event = random.nextInt(7) + 1;
        System.out.println("\n" + ANSIColors.PURPLE + "** Неожиданное событие! **" + ANSIColors.RESET);
        switch (event) {
            case 1 -> {
                System.out.println(ANSIColors.YELLOW + "В древнем склепе вы находите магический амулет, усиливающий вашу меткость." + ANSIColors.RESET);
                skills.shooting += 10;
            }
            case 2 -> {
                System.out.println(ANSIColors.YELLOW + "Пробираясь через лабиринт заброшенных руин, вы обнаруживаете секретный ход," + ANSIColors.RESET);
                System.out.println(ANSIColors.YELLOW + "увеличивающий вашу скрытность и дарующий новые силы." + ANSIColors.RESET);
                skills.stealth += 10;
            }
            case 3 -> {
                System.out.println(ANSIColors.YELLOW + "Изучая древние манускрипты, вы постигли тактику легендарных воинов," + ANSIColors.RESET);
                System.out.println(ANSIColors.YELLOW + "и ваш навык тактики значительно усилился." + ANSIColors.RESET);
                skills.tactics += 10;
            }
            case 4 -> {
                System.out.println(ANSIColors.YELLOW + "В заброшенном сундуке вы находите артефакты великой эпохи," + ANSIColors.RESET);
                System.out.println(ANSIColors.YELLOW + "и энергия предков окрыляет вас. Все навыки получают прирост." + ANSIColors.RESET);
                skills.shooting += 5;
                skills.stealth += 5;
                skills.tactics += 5;
            }
            case 5 -> {
                System.out.println(ANSIColors.YELLOW + "Видение древнего пророка посещает вас, даруя благословение и предвещая великие свершения." + ANSIColors.RESET);
                skills.shooting += 3;
                skills.stealth += 3;
                skills.tactics += 4;
            }
            case 6 -> {
                System.out.println(ANSIColors.YELLOW + "Неожиданно, таинственный голос прошептал вам древние заклинания, наполняя вас силой." + ANSIColors.RESET);
                skills.shooting += 4;
                skills.stealth += 4;
                skills.tactics += 4;
            }
            case 7 -> {
                System.out.println(ANSIColors.YELLOW + "На пути встречается мудрый странник, делящийся с вами секретами забытых битв." + ANSIColors.RESET);
                skills.shooting += 2;
                skills.stealth += 2;
                skills.tactics += 6;
            }
            default -> System.out.println(ANSIColors.YELLOW + "Событие прошло незамеченным, оставив лишь тихий шорох в памяти." + ANSIColors.RESET);
        }
    }

    private void determineBattleOutcome(Skills skills) {
        System.out.println("\n" + ANSIColors.BLUE + "=== Финальное сражение ===" + ANSIColors.RESET);
        int totalSkill = skills.total();
        if (totalSkill > 130) {
            System.out.println(ANSIColors.GREEN + "С потрясающей мощью и стратегией, вы одержали решительную победу!" + ANSIColors.RESET);
            System.out.println(ANSIColors.GREEN + "Ваш успех стал легендой, ознаменовав новый рассвет для сопротивления." + ANSIColors.RESET);
        } else if (totalSkill > 90) {
            System.out.println(ANSIColors.GREEN + "Вы с трудом, но все же победили, проявив невероятное упорство." + ANSIColors.RESET);
            System.out.println(ANSIColors.GREEN + "Эта битва стала важным уроком на пути к великой судьбе." + ANSIColors.RESET);
        } else {
            System.out.println(ANSIColors.RED + "Враг оказался слишком силен. Вы потерпели поражение," + ANSIColors.RESET);
            System.out.println(ANSIColors.RED + "но каждое поражение – это шаг к будущему триумфу." + ANSIColors.RESET);
        }
    }
}
