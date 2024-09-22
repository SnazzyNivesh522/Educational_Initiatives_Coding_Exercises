public class MacOSFactory extends OSFactory{
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public TextField createTextField() {
        return new MacOSTextField();
    }
    @Override
    public Shell createShell() {
        return new MacOSShell();
    }
    
}
