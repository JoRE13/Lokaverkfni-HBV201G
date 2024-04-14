package hi.verkefni.vidmot;

/**
 * Klasinn View.
 */
public enum View {
    KUBBUR("kubbur-view.fxml"),//view þegar lagalisti er valinn
    HEIM("heima-view.fxml"),//view heimasíðu
    NYSKRANING("nyskraning-view.fxml"),
    INNSKRANING("innskraning-view.fxml"),
    BUD("bud-view.fxml");

    private String fileName;//nafn á fxml skrá fyrir view.

    /**
     * Smiður fyrir view.
     * @param fileName nafn á fxml skrá
     */
    View(String fileName) {
        this.fileName = fileName;
    }

    /**
     * skilar nafni á skránni
     * @return
     */
    public String getFileName() {
        return fileName;
    }
}
