import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int earnings = 0;
        int spendings = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите операцию и введите её номер: ");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода");
                    String moneyStr = scanner.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    earnings += money;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода");
                    String moneyExp = scanner.nextLine();
                    int expenses = Integer.parseInt(moneyExp);
                    spendings += expenses;
                    break;
                case 3:
                    int tax1 = taxEarningsMinusSpendings(earnings, spendings);
                    int tax2 = chargeFromIncome(earnings);
                    if (tax2 > tax1) {
                        System.out.println("Мы советуем вам УСН доходы минус расходы");
                        System.out.println("Ваш налог состаит: " + tax1);
                        System.out.println("Налог на другой системе: " + tax2);
                        System.out.println("Экономия: " + savings2(tax1, tax2));
                    } else if (tax2 < tax1) {
                        System.out.println("Мы советуем вам УСН доходы");
                        System.out.println("Ваш налог составит: " + tax2);
                        System.out.println("Налог на другой системе: " + tax1);
                        System.out.println("Экономия: " + savings(tax1, tax2));
                    } else {
                        System.out.println("Можете выбрать любую систему налогообложения");
                    }

                    break;
                default:
                    System.out.println("Такой операции нет");

            }
        }
    }

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static int chargeFromIncome(int earnings) {
        int charge = earnings * 6 / 100;
        return charge;
    }

    public static int savings(int tax, int charge) {
        int tax2 = tax - charge;
        return tax2;
    }

    public static int savings2(int tax, int charge) {
        int tax3 = charge - tax;
        return tax3;
    }
}