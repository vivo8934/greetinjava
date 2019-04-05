package greetings;

public enum Languages {

    English("Hello"),
    IsiXhosa("Molo"),
    Mandarin("Ni hao");

    private final String greets;

    Languages(String greets) {
        this.greets = greets;
    }

    public String getGreets() {
        return greets;
    }
}

