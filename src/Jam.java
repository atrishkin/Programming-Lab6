public class Jam implements Comparable<Jam> {
    private String name; //из чего сделано варенье
    private double size; //литраж банки в литрах
    private int year; //год производства
    private int priority; //чем выше число, тем вкуснее варенье для Карлсона

    Jam() {
    }
    Jam(String n, double s, int y, int p) {
        name = n;
        size = s;
        year = y;
        priority = p;
    }
    @Override
    public int compareTo(Jam o) {
        return (this.priority - o.priority);
    }
    public String getName() {
        return name;
    }
    public double getSize() {
        return size;
    }
    public int getYear() {
        return year;
    }
    public int getPriority() {
        return priority;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSize(double size) {
        this.size = size;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
}