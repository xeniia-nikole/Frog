public class FrogCommands {
    public static FrogCommand jumpRightCommand(Frog frog, int steps) {
        FrogCommand frogCommand = new FrogCommand() {
            @Override
            public boolean doCommand() {
                if (frog.jump(steps)) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public boolean undoCommand() {
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
        FrogCommand frogCommand = new FrogCommand() {
            @Override
            public boolean doCommand() {
                if (frog.jump(steps)) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public boolean undoCommand() {
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

