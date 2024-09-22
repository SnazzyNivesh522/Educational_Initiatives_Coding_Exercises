public class WindowsFactory extends OSFactory{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public TextField createTextField() {
        return new WindowsTextField();
    }
    @Override
    public Shell createShell() {
        return new WindowsShell();
    }
    
}
