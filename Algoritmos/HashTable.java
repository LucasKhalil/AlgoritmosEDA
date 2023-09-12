package Algoritmos;

public class HashTable implements T {

    private T[] content;
    private int order;
    private int size;

    public HashTable(int order) {
        this.content = new T[10];
        this.order = order;
        this.size = 0;
    }

    public void add(String newCode, String newName) {
        if (newCode.length() != this.order) {
            throw new IndexOutOfBoundsException("CÓDIGO PASSADO INVÁLIDO, NÚMERO DE CARACTERES (" + newCode.length()
                    + ") DIFERE DA ORDEM (" + this.order + ")");
        }
        int mat = Integer.valueOf(newCode);
        Aluno newAluno = new Aluno(mat, newName);
        this.add(newAluno);
    }

    public void add(Aluno newAluno) {
        int[] v = newAluno.getContent();
        int position = v[v.length - order];
        if (this.content[position] == null) {
            this.content[position] = newAluno;
        } else if (this.content[position] instanceof HashTable) {
            HashTable newTable = (HashTable) this.content[position];
            newTable.add(newAluno);
            this.content[position] = newTable;
        } else if (newAluno.equals((Aluno) this.content[position])) {
            this.content[position] = newAluno;
            return;
        } else {
            HashTable newTable = new HashTable(this.order - 1);
            newTable.add((Aluno) this.content[position]);
            newTable.add(newAluno);
            this.content[position] = newTable;
        }
    }

    public Aluno getAluno(int matricula) {
        String[] arr = String.valueOf(matricula).split("");
        int[] v = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            v[i] = Integer.valueOf(arr[i]);
        }
        int position = v[v.length - this.order];
        if (this.content[position] == null) {
            return null;
        }
        if (this.content[position] instanceof Aluno) {
            Aluno aluno = (Aluno) this.content[position];
            if (aluno.getMatricula() == matricula) {
                return aluno;
            }
            return null;
        }
        HashTable table = (HashTable) this.content[position];
        return table.getAluno(matricula);
    }

    public void remove(int matricula) {
        String[] arr = String.valueOf(matricula).split("");
        int[] v = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            v[i] = Integer.valueOf(arr[i]);
        }
        int position = v[v.length - this.order];
        if (this.content[position] == null) {
            return;
        }
        if (this.content[position] instanceof Aluno) {
            Aluno aluno = (Aluno) this.content[position];
            if (aluno.getMatricula() == matricula) {
                this.content[position] = null;
                return;
            }
            return;
        }
        HashTable table = (HashTable) this.content[position];
        table.remove(matricula);

    }

    public String toString() {
        String toReturn = "";
        for (int i = 0; i < 10; i++) {
            if (this.content[i] == null)
                continue;
            toReturn += "[LINHA " + i + " " + this.content[i] + "]";
        }
        return toReturn;
    }
}

class Aluno implements T {
    private int matricula;
    private String nome;

    public Aluno(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public boolean equals(Object n) {
        if (n == null) {
            return false;
        }
        if (!(n instanceof Aluno)) {
            return false;
        }
        Aluno aluno = (Aluno) n;
        if (aluno.getMatricula() != this.matricula) {
            return false;
        }
        return true;
    }

    public int getMatricula() {
        return this.matricula;
    }

    public int[] getContent() {
        String[] arr = String.valueOf(this.matricula).split("");
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            toReturn[i] = Integer.valueOf(arr[i]);
        }
        return toReturn;
    }

    public String getNome() {
        return this.nome;
    }

    public String toString() {
        return this.nome;
    }
}

class Main {
    public static void main(String[] args) {
        HashTable ht = new HashTable(9);
        ht.add("122110409", "Lucas Khalil Azevedo Dantas");
        ht.add("222110408", "Random");
        ht.add("121110409", "Aluno período 21.1");
        ht.add("122110409", "Luis Khalil");
    }
}