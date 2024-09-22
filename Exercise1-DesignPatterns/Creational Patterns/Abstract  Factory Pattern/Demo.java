public class Demo {
    public static void main(String[] args) {
        OSFactory windowsfactory = new FactoryProducer().getFactory("Windows");
        Application windowsApp = new Application(windowsfactory);
        windowsApp.render();

        System.out.println("=====================================");

        OSFactory linuxfactory = new FactoryProducer().getFactory("Linux");
        Application linuxApp = new Application(linuxfactory);
        linuxApp.render();

        System.out.println("=====================================");
        OSFactory macosfactory = new FactoryProducer().getFactory("MacOS");
        Application macosApp = new Application(macosfactory);
        macosApp.render();

    }
}
