public class Demo {
    public static void main(String[] args) {
        VideoConverterFacade converter = new VideoConverterFacade();

        converter.convertVideo("myvideo.mp4", "avi");

        System.out.println("=====================================");

        converter.convertVideo("myvideo.avi", "mp4");
    }
}
