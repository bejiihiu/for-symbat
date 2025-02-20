package kz.bejiihiu.game.auth;

import kz.bejiihiu.game.ANSIColors;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserManager {
    private final Map<String, String> users;
    private final Scanner scanner;
    private static final String[] SPECIAL_USERS = {"Symbat"};
    private static final String SPECIAL_PASSWORD = "1234";

    public UserManager() {
        users = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void registerUser() {
        System.out.println(ANSIColors.GREEN + "Регистрация нового участника сопротивления." + ANSIColors.RESET);
        System.out.print(ANSIColors.CYAN + "Введите имя пользователя: " + ANSIColors.RESET);
        String username = scanner.next();
        if (users.containsKey(username)) {
            System.out.println(ANSIColors.RED + "Пользователь с таким именем уже существует. Судьба требует уникальности." + ANSIColors.RESET);
            return;
        }
        System.out.print(ANSIColors.CYAN + "Введите пароль: " + ANSIColors.RESET);
        String password = scanner.next();
        users.put(username, password);
        System.out.println(ANSIColors.GREEN + "Регистрация успешна! Вы сделаны частью великой миссии." + ANSIColors.RESET);
    }

    public boolean authorizeUser() {
        System.out.println(ANSIColors.GREEN + "Авторизация участника сопротивления." + ANSIColors.RESET);
        System.out.print(ANSIColors.CYAN + "Введите имя пользователя: " + ANSIColors.RESET);
        String username = scanner.next();
        if (isSpecialUser(username) && !users.containsKey(username)) {
            System.out.print(ANSIColors.CYAN + "Введите пароль: " + ANSIColors.RESET);
            String password = scanner.next();
            if (SPECIAL_PASSWORD.equals(password)) {
                System.out.println(ANSIColors.GREEN + "Авторизация успешна. Особая сила с вами." + ANSIColors.RESET);
                return false;
            } else {
                System.out.println(ANSIColors.RED + "Неверный пароль. Тьма преградила путь." + ANSIColors.RESET);
                return true;
            }
        }
        if (!users.containsKey(username)) {
            System.out.println(ANSIColors.RED + "Пользователь с таким именем не найден. Возможно, вы еще не пробудились." + ANSIColors.RESET);
            return true;
        }
        System.out.print(ANSIColors.CYAN + "Введите пароль: " + ANSIColors.RESET);
        String password = scanner.next();
        if (users.get(username).equals(password)) {
            System.out.println(ANSIColors.GREEN + "Авторизация успешна. Вы прошли первый рубеж." + ANSIColors.RESET);
            return false;
        } else {
            System.out.println(ANSIColors.RED + "Неверный пароль. Ваш путь прегражден." + ANSIColors.RESET);
            return true;
        }
    }

    private boolean isSpecialUser(String username) {
        for (String special : SPECIAL_USERS) {
            if (special.equals(username)) {
                return true;
            }
        }
        return false;
    }
}
