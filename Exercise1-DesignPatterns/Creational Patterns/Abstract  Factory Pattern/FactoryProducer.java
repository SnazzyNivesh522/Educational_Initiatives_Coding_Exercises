public class FactoryProducer {
    public static OSFactory getFactory(String os) {
        if (os.equalsIgnoreCase("Linux")) {
            return new LinuxFactory();
        } else if (os.equalsIgnoreCase("MacOS")) {
            return new MacOSFactory();
        }
        else if (os.equalsIgnoreCase("Windows")) {
            return new WindowsFactory();
        }
        throw new IllegalArgumentException("OS not supported");
    }
}
