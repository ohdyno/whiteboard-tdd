package io.pivotal.michigan.production;

public class Whiteboard {
    private String name;

    public Whiteboard(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Whiteboard that = (Whiteboard) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}