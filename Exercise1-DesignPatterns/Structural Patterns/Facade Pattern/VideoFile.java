class VideoFile {
    private String fileName;
    public VideoFile(String fileName) {
        this.fileName = fileName;
    }
    public String getFileName() {
        return fileName;
    }
    public void readFile() {
        System.out.println("Reading video file: " + fileName);
    }
}
