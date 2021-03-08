package memento;

import java.util.HashMap;
import java.util.Map;

public class FuncionarioCaretaker {
    protected Map<Integer, Map<String, FuncionarioMemento>> mementoHistorico = new HashMap<Integer, Map<String,
            FuncionarioMemento>>();

    public void addMemento(int id, String mementoMessagem, FuncionarioMemento memento) {
        if (mementoMessagem != null && mementoMessagem.trim().length() != 0 && memento != null) {
            Map<String, FuncionarioMemento> mementoMessageMap = mementoHistorico.get(id);
            if (mementoMessageMap == null) {
                mementoMessageMap = new HashMap<String, FuncionarioMemento>();
                mementoHistorico.put(id, mementoMessageMap);
            }
            mementoMessageMap.put(mementoMessagem, memento);
            System.out.printf("Registro de funcionário '%s' armazenado com mensagem '%s'.\n", memento.getNome(),
                    mementoMessagem);
        }
    }

    public FuncionarioMemento getMemento(int id, String mementoMessage) {
        FuncionarioMemento memento = null;
        if (mementoMessage != null && mementoMessage.trim().length() != 0) {
            Map<String, FuncionarioMemento> mementoMessageMap = mementoHistorico.get(id);
            if (mementoMessageMap != null) {
                memento = mementoMessageMap.get(mementoMessage);
                if (memento != null) {
                    System.out.printf("Registro de funcionário '%s' armazenado com mensagem '%s' recuperado\n",
                            memento.getNome(),
                            mementoMessage);
                } else {
                    System.err.println("Não foi possível encontrar o memento!");
                }
            }
        }
        return memento;
    }

    public void printStoredMementoObjects() {
        System.out.println("======================================================");
        mementoHistorico.forEach((id, mementoMessageMap) -> {
            mementoMessageMap.forEach((message, memento) -> {
                System.out.printf("Id: '%d', Messagem: '%s', Memento: '%s'\n", id, message, memento);
            });
        });
        System.out.println("======================================================");
    }
}
