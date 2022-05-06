public class Main {
    public static void main(String[] args) {
        Person dad = new PersonBuilder()
                .setName("Евгений")
                .setSurname("Денисов")
                .setAge(29)
                .setAddress("Челябинск")
                .build();

        Person son = dad.newChildBuilder()
                .setName("Ева")
                .setAge(1)
                .build();
        System.out.println("У " + dad + " есть дочь, " + son);

        Person personWithoutAge = new PersonBuilder()
                .setName("Иван")
                .setSurname("Петров")
                .setAddress("Москва")
                .build();
        System.out.println("У " + personWithoutAge.getName() + " есть адрес? - " +
                personWithoutAge.hasAddress());
        System.out.println(personWithoutAge);

        Person personWithoutAddress = new PersonBuilder()
                .setName("Юлия")
                .setSurname("Фролова")
                .setAge(18)
                .build();
        personWithoutAddress.happyBirthday();
        System.out.println("У " + personWithoutAddress.getName() + " есть адрес? - " +
                personWithoutAddress.hasAddress());
        System.out.println(personWithoutAddress);

        try {
            // Не хватает обязательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}