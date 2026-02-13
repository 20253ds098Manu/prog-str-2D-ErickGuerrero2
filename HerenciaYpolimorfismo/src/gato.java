public class gato extends animal{

        public gato(String name) {
            super(name);
        }

        @Override
    public void hacerSonido(){
            System.out.println(name+" hace Miaw o Rawrl ");
        }
    }
