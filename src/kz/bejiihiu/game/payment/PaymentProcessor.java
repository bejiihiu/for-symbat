package kz.bejiihiu.game.payment;

import kz.bejiihiu.game.ANSIColors;

public class PaymentProcessor {
    private static final int PAYMENT_RATE = 1000;

    public void processPayment(int hours) {
        int totalCost = hours * PAYMENT_RATE;
        System.out.println(ANSIColors.CYAN + "Ритуальный взнос за " + hours + " час(ов) битвы составляет: " + totalCost + " тенге." + ANSIColors.RESET);
        System.out.println(ANSIColors.GREEN + "Платеж принят, и врата арены открыты для вас." + ANSIColors.RESET);
    }
}
