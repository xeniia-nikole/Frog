import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //...
        List<FrogCommands> commands = new ArrayList<>();
        int curCommand = -1;
        while (true) {
            //считываем ввод и конструируем комманду, если
            //пользователь не хотел выйти

            if (/*пользователь хочет отменить действие*/) {
                if (curCommand < 0) {
                    System.out.println("Нечего отменять!");
                } else {
                    commands.get(curCommand).undo();
                    curCommand--;
                }
            } else if (/*пользователь хочет повторить действие*/) {
                if (curCommand == commands.size() - 1) {
                    System.out.println("Нечего отменять!");
                } else {
                    curCommand++;
                    commands.get(curCommand).do();
                }
            } else { //пользователь ввёл новое движение для лягушки
                if (curCommand != commands.size() - 1) {
                    //удаляем все команды которые были отменены
                }
                FrogCommand cmd = ...
                curCommand++;
                commands.add(cmd);
                cmd.do();
            }

            //рисуем поле после команды
        }
    }

}
