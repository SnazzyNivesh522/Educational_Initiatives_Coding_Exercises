public class LinuxFactory extends OSFactory{
    @Override
    public Button createButton() {
        return new LinuxButton();
    }

    @Override
    public TextField createTextField() {
        return new LinuxTextField();
    }
    @Override
    public Shell createShell() {
        return new LinuxShell();
    }
    
}
