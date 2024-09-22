public class Application {
    private Button button;
    private TextField textField;
    private Shell shell;
    public Application(OSFactory factory){
        button = factory.createButton();
        textField = factory.createTextField();
        shell = factory.createShell();
    }
    public void render(){
        button.click();
        textField.setText("Hello World");
        shell.setShell("");
    }
}
