package kz.bejiihiu.game.story;

import kz.bejiihiu.game.ANSIColors;

public class Story implements IStory {
    @Override
    public void displayPrologue() {
        System.out.println(ANSIColors.PURPLE + "=== Пролог ===" + ANSIColors.RESET);
        System.out.println(ANSIColors.YELLOW + "В глубинах забвения, среди руин древних цивилизаций," + ANSIColors.RESET);
        System.out.println(ANSIColors.YELLOW + "возрождается легенда о воине, способном повернуть ход истории." + ANSIColors.RESET);
        System.out.println(ANSIColors.GREEN + "Судьба мира висит на волоске, и только истинный герой способен зажечь огонь надежды." + ANSIColors.RESET);
        System.out.println(ANSIColors.YELLOW + "Сквозь тьму и хаос, через испытания боли и утрат, начинается ваше эпическое путешествие." + ANSIColors.RESET);
    }

    @Override
    public void displayTransition(String act) {
        System.out.println("\n" + ANSIColors.BLUE + "=== " + act + " ===" + ANSIColors.RESET);
    }
}
