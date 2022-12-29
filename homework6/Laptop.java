public class Laptop {
    String brand;
    String model;
    String color;
    String screenSize;
    int hardDiskSize;
    String hardDiskType;
    int ram;
    String os;
    String resolution;
    double weight;
    String graphicsCoprocessor;
    String processor;
    int cpuSpeed;
    int processorCount;

    int price;

    public Laptop(String brand, String model, String color, String resolution, String screenSize,
                  String processor, int cpuSpeed, int processorCount, int ram,
                  String hardDiskType, int hardDiskSize, String graphicsCoprocessor,
                  String os, double weight, int price) {

        this.brand = brand;
        this.model = model;
        this.color = color;
        this.screenSize = screenSize;
        this.hardDiskType = hardDiskType;
        this.hardDiskSize = hardDiskSize;
        this.ram = ram;
        this.os = os;
        this.resolution = resolution;
        this.weight = weight;
        this.graphicsCoprocessor = graphicsCoprocessor;
        this.processor = processor;
        this.processorCount = processorCount;
        this.cpuSpeed = cpuSpeed;
        this.price = price;

    }

    @Override
    public String toString() {
        return "\nПроизводитель: " + brand + "\n"
                +"Модель: " + model + "\n"
                + "Цвет: " + color + "\n"
                + "Разрешение экрана: " + resolution + "\n"
                + "Диагональ экрана: " + screenSize + "\n"
                + "Процессор: " + processor + "\n"
                + "Частота процессора: " + cpuSpeed + " МГц" + "\n"
                + "Количество ядер процессора: " + processorCount + "\n"
                + "Оперативная память: " + ram + " ГБ" + "\n"
                + "Тип накопителя: " + hardDiskType + "\n"
                + "Объем накопителя: " + hardDiskSize + " ГБ" + "\n"
                + "Видеокарта: " + graphicsCoprocessor + "\n"
                + "Операционная система: " + os + "\n"
                + "Вес: " + weight + " кг" + "\n"
                + "Цена: " + price + " рублей" + "\n" + "\n";

    }

}
