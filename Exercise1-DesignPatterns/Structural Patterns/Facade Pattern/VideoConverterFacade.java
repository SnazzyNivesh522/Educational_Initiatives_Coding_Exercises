public class VideoConverterFacade {
    public void convertVideo(String fileName, String format) {
        VideoFile file = new VideoFile(fileName);
        file.readFile();
        
        Codec sourceCodec = CodecFactory.extract(file);
        VideoDecoder decoder = new VideoDecoder();
        decoder.decode(file, sourceCodec);

        Codec destinationCodec = null;
        if (format.equalsIgnoreCase("mp4")) {
            destinationCodec = new MP4Codec();
        } else if (format.equalsIgnoreCase("avi")) {
            destinationCodec = new AVICodec();
        } else {
            throw new IllegalArgumentException("Unsupported output format");
        }

        VideoEncoder encoder = new VideoEncoder();
        encoder.encode(file, destinationCodec);

        VideoFileSaver saver = new VideoFileSaver();
        saver.save(file);
        
        System.out.println("Video conversion completed: " + format);
    }
}
