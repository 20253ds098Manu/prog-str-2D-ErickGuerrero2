public class animal {
    protected String name;

    public animal(String name) {
        this.name = name;
    }
    public void hacerSonido(){
        System.out.println("Hace un sonidp");
    }

    public void comer(){
        System.out.println(name+" esta comiendo");

}
}