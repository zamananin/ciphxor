import org.kohsuke.args4j.*;

public class CipheringXor {
    @Option(name = "-c")
    String keyC;

    @Option(name = "-d")
    String keyD;

    @Argument()
    String inputName;

    @Option(name = "-o")
    String outputName;

    private Data launch(String[] args) throws Exception {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.out.println("Use correct form [-c key] [-d key] inputName.txt [-o outputName.txt]");
            parser.printUsage(System.err);
            System.exit(1);
        }
        return new Data(inputName, outputName, keyC, keyD);
    }

    public static void main(String[] args) {
        Data data = null;
        try {
            data = new CipheringXor().launch(args);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        try {
            Ciphering.ciphering(data.getInputName(), data.getOutputName(), data.getKey());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        System.out.println("Recorded in " + data.getOutputName());

//        int i = 0;
//        String massage = "Use correct form [-c key] [-d key] inputName.txt [-o outputName.txt]";
//
//        if (args.length != 3 && args.length != 5) {
//            i = args.length;
//            System.out.println(massage);
//        }
//
//        while (i < args.length) {
//            switch (args[i]) {
//                case ("-c"), ("-d") -> {
//                    try {
//                        key = new Key(args[1]);
//                    } catch (IllegalArgumentException e) {
//                        System.out.println(e.getMessage());
//                        i = args.length;
//                        break;
//                    }
//                    inputName = args[i];
//                    i++;
//                }
//                case ("-o") -> {
//                    outputName = args[i++];
//                    i++;
//                }
//                default -> {
//                    System.out.println(massage);
//                    i = args.length;
//                }
//            }
//        }
//
//        if (inputName == null) System.out.println(massage);
//        else {
//            if (outputName == null)
//                outputName = inputName.replace(".", args[0] + ".");
//        }
    }
}
