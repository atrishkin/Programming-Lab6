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
    public int compareTo(Jam j) {
        if(Storage.getCompareCount() > 0){
            return (j.priority - this.priority);
        } else {
            return (this.priority - j.priority);
        }
    }
    String getName() {
        return name;
    }
    double getSize() {
        return size;
    }
    int getYear() {
        return year;
    }
    int getPriority() {
        return priority;
    }
    void setName(String name) {
        this.name = name;
    }
    void setSize(double size) {
        this.size = size;
    }
    void setYear(int year) {
        this.year = year;
    }
    void setPriority(int priority) {
        this.priority = priority;
    }
}