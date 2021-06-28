public class FrogCommands {
    public static FrogCommand jumpRightCommand(Frog frog, int steps) {
        // возвращаете объект команды, у которого
        // если вызвать .do(), то лягушка её выполнит,
        // если вызвать .undo(), то лягушка её отменит
        FrogCommand frogCommand = new FrogCommand() {
            @Override
            public boolean doIt() {
                if (frog.jump(steps)) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public boolean undoIt() {
                if (frog.jump(-steps)) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        return frogCommand;
    }

    public static FrogCommand jumpLeftCommand(Frog frog, int steps) {
        // возвращаете объект команды, у которого
        // если вызвать .do(), то лягушка её выполнит,
        // если вызвать .undo(), то лягушка её отменит
        FrogCommand frogCommand = new FrogCommand() {
            @Override
            public boolean doIt() {
                if (frog.jump(steps)) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public boolean undoIt() {
                if (frog.jump(-steps)) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        return frogCommand;
    }

}

