package kz.bejiihiu.game.tournament;

import kz.bejiihiu.game.ANSIColors;
import java.util.Random;

public class Tournament {
    private final Random random;

    public Tournament() {
        random = new Random();
    }

    public void determineWinner(int gameChoice) {
        System.out.println("\n" + ANSIColors.BLUE + "=== Турнир: Испытание судьбы ===" + ANSIColors.RESET);
        System.out.println(ANSIColors.YELLOW + "На этой арене решается судьба не только участника, но и всего сопротивления." + ANSIColors.RESET);
        switch (gameChoice) {
            case 1 -> System.out.println(ANSIColors.CYAN + "DOTA 2 – арена, где древние руны и магия переплетаются с тактикой битвы." + ANSIColors.RESET);
            case 2 -> System.out.println(ANSIColors.CYAN + "Counter-Strike – место, где скорость реакции и стратегия определяют исход сражения." + ANSIColors.RESET);
            case 3 -> System.out.println(ANSIColors.CYAN + "League of Legends – мир, где мифы и легенды оживают в каждом столкновении." + ANSIColors.RESET);
            default -> System.out.println(ANSIColors.RED + "Неизвестная арена. Турнир сорвался, и испытание было отменено." + ANSIColors.RESET);
        }

        if (random.nextBoolean()) {
            System.out.println(ANSIColors.GREEN + "С невероятной храбростью и тактическим расчетом, ваша команда одержала победу!" + ANSIColors.RESET);
            System.out.println(ANSIColors.GREEN + "Эта победа стала зарей нового рассвета для всех повстанцев." + ANSIColors.RESET);
        } else {
            System.out.println(ANSIColors.RED + "Противники оказались слишком коварны, и победа ускользнула из ваших рук." + ANSIColors.RESET);
            System.out.println(ANSIColors.RED + "Но поражение лишь закаляет дух, готовя его к будущим сражениям." + ANSIColors.RESET);
        }
    }
}
