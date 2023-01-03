import java.util.*;
import java.util.stream.Collectors;

public class laptopStore {
    public static void main(String[] args) {
        
        HashSet<Laptop> laptops = new HashSet<>();
        fillLaptopList(laptops);
        
        Map<Integer, String> characteristics = new HashMap<>();
        fillCharacteristicsList(characteristics);
        
        Scanner scan = new Scanner(System.in);

        int[] answer = criteria(characteristics);
        System.out.println(Arrays.toString(answer));

        String chosenBrand = chosenBrand(scan, answer);
        String chosenColor = chosenColor(scan, answer);
        String chosenResolution = chosenResolution(scan, answer);
        String chosenScreenSize = chosenScreenSize(scan, answer);
        String chosenProcessor = chosenProcessor(scan, answer);
        int chosenProcessorCount = chosenProcessorCount(scan, answer);
        int chosenRam = chosenRam(scan, answer);
        int chosenHardDiskSize = chosenHardDiskSize(scan, answer);
        String chosenGraphicsCoprocessor = chosenGraphicsCoprocessor(scan, answer);
        String chosenOS = chosenOS(scan, answer);
        int chosenPrice = ChosenPrice(scan, answer);


        HashSet<Laptop> firstPart = new HashSet<>(filteredScreenSize(chosenScreenSize, filteredRes(chosenResolution,
                filteredColor(chosenColor, filteredBrand(chosenBrand, laptops)))));
        HashSet<Laptop> secondPart = new HashSet<>(filteredHardDiskSize(chosenHardDiskSize, filteredRam(chosenRam,
                filteredProcessorCount(chosenProcessorCount, filteredProcessor(chosenProcessor, firstPart)))));
        HashSet<Laptop> res = new HashSet<>(filteredPrice(chosenPrice, filteredOS(chosenOS,
                filteredGraphicsCoprocessor(chosenGraphicsCoprocessor, secondPart))));


        if (!res.isEmpty()) {
            System.out.println(res);
        }
        else {
            System.out.println("К сожалению, по заданным параметрам ничего не нашлось :(");
        }


    }

    
    public static HashSet<Laptop> fillLaptopList (HashSet<Laptop> laptops) {

        Laptop l1 = new Laptop("ASUS", "X415KA-EK070W", "Silver", "1920x1080", "14'",
                "Intel Pentium Silver", 1100, 4, 4, "SSD",
                128, "Intel UHD Graphics",
                "Windows 10 Home", 1.55, 29990);

        Laptop l2 = new Laptop("HUAWEI", "MateBook D 16", "Black", "1920x1200", "16'",
                "Intel Core i7", 2300, 12, 16, "SSD", 256,
                "Intel Iris Xe Graphics", "Windows 11 Home", 1.71, 78990);

        Laptop l3 = new Laptop("Apple", "Macbook Pro 16", "Grey", "3456×2234", "16.2'",
                "Apple M1 Max", 3200, 10, 32, "SSD", 1000,
                "Apple graphics 32-core", "macOS", 2.17, 477293);

        Laptop l4 = new Laptop("HUAWEI", "MateBook D 16", "White", "2560x1600", "16'",
                "Intel Core i9", 2300, 12, 16, "SSD", 512,
                "Intel Iris Xe Graphics", "Windows 11 Pro", 1.81, 103990);

        Laptop l5 = new Laptop("HP", "250 G8", "Silver", "1920x1080", "15.6'",
                "Intel Core i5", 1200, 2, 4, "SSD", 128,
                "Intel UHD Graphics 605", "Windows 10 Pro", 1.74, 34990);

        Laptop l6 = new Laptop("ASUS", "Vivobook Go 14 E410", "Black", "1920x1080",
                "14'", "Intel Pentium Silver", 2400, 4, 16, "SSD",
                128, "Intel UHD Graphics", "Windows 11 Home", 1.3, 38290);

        Laptop l7 = new Laptop("Lenovo", "ThinkBook K3", "Grey", "1920x1200",
                "13.3'", "Intel Core i5", 2400, 4, 16, "SSD",
                512, "Intel Iris Xe Graphics", "Windows 11 Home", 1.26, 58250);

        Laptop l8 = new Laptop("HP", "T17-by1", "Red", "1920x1080",
                "17'", "Intel Pentium Gold", 2400, 2, 4, "HDD",
                1000, "Intel UHD Graphics", "Windows 10 Home", 2.51, 47800);

        Laptop l9 = new Laptop("Acer", "Nitro 5 ", "White", "1920x1080",
                "15.6'", "Intel Core i5", 2700, 6, 16, "SSD",
                512, "Intel UHD Graphics", "Windows 10 Home", 2.3, 79990);

        Laptop l10 = new Laptop("Apple", "MacBook Pro 13", "Grey", "2560x1600",
                "13.3'", "Apple M1", 3200, 8, 8, "SSD",
                512, "Apple graphics 8-core", "macOS", 1.4, 79990);

        
        laptops.add(l1);
        laptops.add(l2);
        laptops.add(l3);
        laptops.add(l4);
        laptops.add(l5);
        laptops.add(l6);
        laptops.add(l7);
        laptops.add(l8);
        laptops.add(l9);
        laptops.add(l10);

        return laptops;
        
    }

    public static Map<Integer, String> fillCharacteristicsList (Map<Integer, String> characteristics) {
        characteristics.put(1, "Производитель");
        characteristics.put(2, "Цвет");
        characteristics.put(3, "Разрешение экрана");
        characteristics.put(4, "Диагональ экрана");
        characteristics.put(5, "Процессор");
        characteristics.put(6, "Количество ядер процессора");
        characteristics.put(7, "Оперативная память");
        characteristics.put(8, "Объем накопителя");
        characteristics.put(9, "Видеокарта");
        characteristics.put(10, "Операционная система");
        characteristics.put(11, "Цена");

        return characteristics;
    }

    public static String chosenBrand(Scanner scan, int[] answer) {
        Map<Integer, String> brands = new HashMap<>();
        brands.put(1, "ASUS");
        brands.put(2, "Apple");
        brands.put(3, "HUAWEI");
        brands.put(4, "Lenovo");
        brands.put(5, "Acer");
        brands.put(6, "HP");

        String chosenBrand = "";

        for (int j : answer) {
            if (j == 1) {
                System.out.println("Выберите производителя: ");
                for (Map.Entry<Integer, String> entry : brands.entrySet()) {
                    System.out.printf("%d - %s \n", entry.getKey(), entry.getValue());
                }
                int choice = scan.nextInt();
                chosenBrand = brands.get(choice);
            }
        }
        return chosenBrand;
    }


    public static String chosenColor(Scanner scan, int[] answer) {
        Map<Integer, String> colors = new HashMap<>();
        colors.put(1, "Silver");
        colors.put(2, "Grey");
        colors.put(3, "Black");
        colors.put(4, "White");
        colors.put(5, "Red");

        String chosenColor = "";

        for (int j : answer) {
            if (j == 2) {
                System.out.println("Выберите цвет: ");
                for (Map.Entry<Integer, String> entry : colors.entrySet()) {
                    System.out.printf("%d - %s \n", entry.getKey(), entry.getValue());
                }
                int choice = scan.nextInt();
                chosenColor = colors.get(choice);
            }
        }
        return chosenColor;
    }

    public static String chosenResolution(Scanner scan, int[] answer) {
        Map<Integer, String> res = new HashMap<>();
        res.put(1, "1920x1080");
        res.put(2, "1920x1200");
        res.put(3, "2560x1600");
        res.put(4, "3456x2234");

        String chosenResolution = "";

        for (int j : answer) {
            if (j == 3) {
                System.out.println("Выберите разрешение экрана: ");
                for (Map.Entry<Integer, String> entry : res.entrySet()) {
                    System.out.printf("%d - %s \n", entry.getKey(), entry.getValue());
                }
                int choice = scan.nextInt();
                chosenResolution = res.get(choice);

            }
        }
        return chosenResolution;
    }

    public static String chosenScreenSize(Scanner scan, int[] answer) {
        Map<Integer, String> screenSize = new HashMap<>();
        screenSize.put(1, "13.3'");
        screenSize.put(2, "14'");
        screenSize.put(3, "15.6'");
        screenSize.put(4, "16'");
        screenSize.put(5, "16.2'");
        screenSize.put(6, "17'");

        String chosenScreenSize = "";

        for (int j : answer) {
            if (j == 4) {
                System.out.println("Выберите диагональ экрана: ");
                for (Map.Entry<Integer, String> entry : screenSize.entrySet()) {
                    System.out.printf("%d - %s \n", entry.getKey(), entry.getValue());
                }
                int choice = scan.nextInt();
                chosenScreenSize = screenSize.get(choice);

            }
        }
        return chosenScreenSize;

    }


    public static String chosenProcessor(Scanner scan, int[] answer) {
        Map<Integer, String> processors = new HashMap<>();
        processors.put(1, "Intel Core i5");
        processors.put(2, "Intel Core i7");
        processors.put(3, "Intel Core i9");
        processors.put(4, "Intel Pentium Silver");
        processors.put(5, "Intel Pentium Gold");
        processors.put(6, "Apple M1 Max");
        processors.put(7, "Apple M1");

        String chosenProcessor = "";

        for (int j : answer) {
            if (j == 5) {
                System.out.println("Выберите процессор: ");
                for (Map.Entry<Integer, String> entry : processors.entrySet()) {
                    System.out.printf("%d - %s \n", entry.getKey(), entry.getValue());
                }
                int choice = scan.nextInt();
                chosenProcessor = processors.get(choice);

            }
        }
        return chosenProcessor;

    }

    public static int chosenProcessorCount(Scanner scan, int[] answer) {
        Map<Integer, Integer> count = new HashMap<>();
        count.put(1, 2);
        count.put(2, 4);
        count.put(3, 6);
        count.put(4, 8);
        count.put(5, 10);
        count.put(6, 12);

        int chosenProcessorCount = 0;

        for (int j : answer) {
            if (j == 6) {
                System.out.println("Выберите количество ядер процессора: ");
                for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                    System.out.printf("%d - %d \n", entry.getKey(), entry.getValue());
                }
                int choice = scan.nextInt();
                chosenProcessorCount = count.get(choice);

            }
        }
        return chosenProcessorCount;

    }

    public static int chosenRam(Scanner scan, int[] answer) {
        Map<Integer, Integer> ram = new HashMap<>();
        ram.put(1, 4);
        ram.put(2, 8);
        ram.put(3, 12);
        ram.put(4, 16);
        ram.put(5, 32);

        int chosenRam = 0;

        for (int j : answer) {
            if (j == 7) {
                System.out.println("Выберите объем оперативной памяти: ");
                for (Map.Entry<Integer, Integer> entry : ram.entrySet()) {
                    System.out.printf("%d - %d ГБ \n", entry.getKey(), entry.getValue());
                }
                int choice = scan.nextInt();
                chosenRam = ram.get(choice);

            }
        }
        return chosenRam;

    }

    public static int chosenHardDiskSize(Scanner scan, int[] answer) {
        Map<Integer, Integer> diskSize = new HashMap<>();
        diskSize.put(1, 128);
        diskSize.put(2, 256);
        diskSize.put(3, 512);
        diskSize.put(4, 1000);

        int chosenHardDiskSize = 0;

        for (int j : answer) {
            if (j == 8) {
                System.out.println("Выберите объем накопителя: ");
                for (Map.Entry<Integer, Integer> entry : diskSize.entrySet()) {
                    System.out.printf("%d - %d ГБ \n", entry.getKey(), entry.getValue());
                }
                int choice = scan.nextInt();
                chosenHardDiskSize = diskSize.get(choice);

            }
        }
        return chosenHardDiskSize;

    }

    public static String chosenGraphicsCoprocessor(Scanner scan, int[] answer) {
        Map<Integer, String> graphics = new HashMap<>();
        graphics.put(1, "Intel UHD Graphics");
        graphics.put(2, "Intel Iris Xe Graphics");
        graphics.put(3, "Apple graphics 32-core");
        graphics.put(4, "Intel UHD Graphics 605");
        graphics.put(5, "Apple graphics 8-core");


        String chosenGraphicsCoprocessor = "";

        for (int j : answer) {
            if (j == 9) {
                System.out.println("Выберите видеокарту: ");
                for (Map.Entry<Integer, String> entry : graphics.entrySet()) {
                    System.out.printf("%d - %s \n", entry.getKey(), entry.getValue());
                }
                int choice = scan.nextInt();
                chosenGraphicsCoprocessor = graphics.get(choice);

            }
        }
        return chosenGraphicsCoprocessor;
    }


    public static String chosenOS(Scanner scan, int[] answer) {
        Map<Integer, String> os = new HashMap<>();
        os.put(1, "macOS");
        os.put(2, "Windows 10 Home");
        os.put(3, "Windows 11 Home");
        os.put(4, "Windows 10 Pro");
        os.put(5, "Windows 11 Pro");

        String chosenOS = "";

        for (int j : answer) {
            if (j == 10) {
                System.out.println("Выберите операционную систему: ");
                for (Map.Entry<Integer, String> entry : os.entrySet()) {
                    System.out.printf("%d - %s \n", entry.getKey(), entry.getValue());
                }
                int choice = scan.nextInt();
                chosenOS = os.get(choice);

            }
        }
        return chosenOS;
    }


    public static int ChosenPrice(Scanner scan, int[] answer) {
        int priceHigh = 0;

        for (int j : answer) {
            if (j == 11) {
                System.out.println("Введите максимальную цену: ");
                priceHigh = scan.nextInt();
            }
        }
        return priceHigh;
    }

    public static int[] criteria(Map<Integer, String> map) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите цифры, соответствующие необходимым параметрам через пробел:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.printf("%d - %s \n", entry.getKey(), entry.getValue());
        }
        String line = scan.nextLine();
        return Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
    }


    public static HashSet<Laptop> filteredBrand(String chosenBrand, HashSet<Laptop> laptops) {
        if (!Objects.equals(chosenBrand, "")) {
            return laptops.stream().filter(laptop -> chosenBrand.equals(laptop.brand)).
                    collect(Collectors.toCollection(HashSet::new));
        } else return laptops;

    }

    public static HashSet<Laptop> filteredColor(String chosenColor, HashSet<Laptop> laptops) {
        if (!Objects.equals(chosenColor, "")) {
            return (HashSet<Laptop>) laptops.stream().filter(laptop -> chosenColor.equals(laptop.color)).
                    collect(Collectors.toSet());
        } else return laptops;
    }

    public static HashSet<Laptop> filteredRes(String chosenResolution, HashSet<Laptop> laptops) {
        if (!Objects.equals(chosenResolution, "")) {
            return (HashSet<Laptop>) laptops.stream().filter(laptop -> chosenResolution.equals(laptop.resolution)).
                    collect(Collectors.toSet());
        } else return laptops;
    }

    public static HashSet<Laptop> filteredScreenSize(String chosenScreenSize, HashSet<Laptop> laptops) {
        if (!Objects.equals(chosenScreenSize, "")) {
            return (HashSet<Laptop>) laptops.stream().filter(laptop -> chosenScreenSize.equals(laptop.screenSize)).
                    collect(Collectors.toSet());
        } else return laptops;
    }

    public static HashSet<Laptop> filteredProcessor(String chosenProcessor, HashSet<Laptop> laptops) {
        if (!Objects.equals(chosenProcessor, "")) {
            return (HashSet<Laptop>) laptops.stream().filter(laptop -> chosenProcessor.equals(laptop.processor)).
                    collect(Collectors.toSet());
        } else return laptops;
    }

    public static HashSet<Laptop> filteredProcessorCount(int chosenProcessorCount, HashSet<Laptop> laptops) {
        if (chosenProcessorCount != 0) {
            return (HashSet<Laptop>) laptops.stream().filter(laptop -> chosenProcessorCount == laptop.processorCount).
                    collect(Collectors.toSet());
        } else return laptops;
    }

    public static HashSet<Laptop> filteredRam(int chosenRam, HashSet<Laptop> laptops) {
        if (chosenRam != 0) {
            return (HashSet<Laptop>) laptops.stream().filter(laptop -> chosenRam == laptop.ram).
                    collect(Collectors.toSet());
        } else return laptops;
    }

    public static HashSet<Laptop> filteredHardDiskSize(int chosenHardDiskSize, HashSet<Laptop> laptops) {
        if (chosenHardDiskSize != 0) {
            return (HashSet<Laptop>) laptops.stream().filter(laptop -> chosenHardDiskSize == laptop.hardDiskSize).
                    collect(Collectors.toSet());
        } else return laptops;
    }

    public static HashSet<Laptop> filteredGraphicsCoprocessor(String chosenGraphicsCoprocessor, HashSet<Laptop> laptops) {
        if (!Objects.equals(chosenGraphicsCoprocessor, "")) {
            return (HashSet<Laptop>) laptops.stream().filter(laptop -> chosenGraphicsCoprocessor.equals(laptop.graphicsCoprocessor)).
                    collect(Collectors.toSet());
        } else return laptops;
    }

    public static HashSet<Laptop> filteredOS(String chosenOS, HashSet<Laptop> laptops) {
        if (!Objects.equals(chosenOS, "")) {
            return (HashSet<Laptop>) laptops.stream().filter(laptop -> chosenOS.equals(laptop.os)).
                    collect(Collectors.toSet());
        } else return laptops;
    }

    public static HashSet<Laptop> filteredPrice(int chosenPrice, HashSet<Laptop> laptops) {
        if (chosenPrice != 0) {
            return (HashSet<Laptop>) laptops.stream().filter(laptop -> chosenPrice >= laptop.price).
                    collect(Collectors.toSet());
        } else return laptops;
    }
}

