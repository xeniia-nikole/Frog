import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final String LEFT = "<";
    public static final String RIGHT = ">";
    public static final String UNDO = "-";
    public static final String REDO = "+" ;
    public static final String DOAGAIN = "!";

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        List<FrogCommand> commands = new ArrayList<>();
        int curCommand = -1;

        Frog frog = new Frog();

        boolean jump = false;

        System.out.println("Начинаем прыжки!");
        paintPosition(frog.getPosition());

        while (true) {
            menu();
            String enter = scanner.next();

            if (enter.equals("0")) break;

            switch (enter) {
                case UNDO:  // Undo (отмени последнюю команду)
                    if ((curCommand < 0) || !jump) {
                        System.out.println("Нечего отменять!");
                    } else {
                        commands.get(curCommand).undoCommand();
                        curCommand--;
                    }
                    break;
                case REDO:  // Redo (повтори отменённую команду)
                    if (curCommand == commands.size() - 1) {
                        System.out.println("Нет отмененных команд!");
                    } else {
                        curCommand++;
                        commands.get(curCommand).doCommand();
                    }
                    break;
                case DOAGAIN:  // повтори последнюю команду
                    if (curCommand <= 0) {
                        System.out.println("Нечего повторять!");
                    } else {
                        commands.get(curCommand).doCommand();
                        curCommand++;
                    }
                    break;
                case RIGHT: { // jump right
                    System.out.print("Введите длину прыжка лягушки: ");
                    int stepsRight = scanner.nextInt();
                    FrogCommand cmd = FrogCommands.jumpRightCommand(frog, stepsRight);
                    curCommand++;
                    commands.add(cmd);
                    jump = cmd.doCommand();
                    break;
                }
                case LEFT: { // jump left
                    System.out.print("Введите длину прыжка лягушки: ");
                    int stepsLeft = scanner.nextInt();
                    FrogCommand cmd = FrogCommands.jumpLeftCommand(frog, -stepsLeft);
                    curCommand++;
                    commands.add(cmd);
                    jump = cmd.doCommand();
                    break;
                }
                default:
                    System.out.println("Вы ввели какую-то странную команду...");
                    break;
            }

            paintPosition(frog.getPosition());

        }

    }

    public static void paintPosition(int position) {
        System.out.println("\nПоложение лягушки в данный момент: ");
        for (int i = 0; i < position; i++) {
            System.out.print(" ~ ");
        }
        System.out.print(" U ");
        for (int i = position; i < (Frog.MAX_POSITION); i++) {
            System.out.print(" ~ ");
        }
        System.out.println();
        for (int i = 0; i < (Frog.MAX_POSITION + 1); i++) {
            System.out.format(" %d ", i);
        }
        System.out.println();
    }

    private static void menu() {
        System.out.print(
                """
                        Ввведите команду для лягушки:
                        > - прыгни на N шагов направо
                        < - прыгни на N шагов налево
                        - - отмени последнюю команду
                        + - выполни отменённую команду
                        ! - повтори последнюю команду (не отмененную)
                        0 - выход
                        :\s""");

    }

}
