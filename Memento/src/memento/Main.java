package memento;

public class Main {
    public static void main(String[] args) {
        FuncionarioCaretaker caretaker = new FuncionarioCaretaker();
        System.out.println("Criando funcionário com seus valores inciais");
        Funcionario ivan = new Funcionario(100).setNome("Ivan").setSalario(5000);
        System.out.println(ivan);
        FuncionarioMemento ivanMemento = ivan.createMemento();
        caretaker.addMemento(ivanMemento.getId(), "Salvo no estado inicial", ivanMemento);


        System.out.println("\nIvan conseguiu uma promoção");
        ivan.setSalario(7000);
        System.out.println(ivan);
        ivanMemento = ivan.createMemento();
        caretaker.addMemento(ivanMemento.getId(), "Salvo após a promoção", ivanMemento);


        System.out.println("\nIvan conseguiu outra promoção");
        ivan.setSalario(10000);
        System.out.println(ivan);
        ivanMemento = ivan.createMemento();
        caretaker.addMemento(ivanMemento.getId(), "Salvo após a segunda promoção", ivanMemento);


        System.out.println("\nObjetos mementos salvos até agora:");
        caretaker.printStoredMementoObjects();


        System.out.println("\nAgora, vamos retornar Ivan ao estado inicial.");
        ivanMemento = caretaker.getMemento(ivan.getId(), "Salvo no estado inicial");
        ivan.restore(ivanMemento);
        System.out.println(ivan);
    }
}
