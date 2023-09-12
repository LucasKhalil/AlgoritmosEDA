package Algoritmos;

public class HashTable implements T {

    private T[] content;
    private int order;

    public HashTable(int order) {
        this.content = new T[10];
        this.order = order;
    }

    public void add(String newCode, String newName) {
        if (newCode.length() != this.order) {
            throw new IndexOutOfBoundsException("CÓDIGO PASSADO INVÁLIDO, NÚMERO DE CARACTERES (" + newCode.length()
                    + ") DIFERE DA ORDEM (" + this.order + ")");
        }
        int mat = Integer.valueOf(newCode);
        Aluno newAluno = new Aluno(mat, newName);
        int[] v = newAluno.getContent();
        int position = v[v.length - order];
        if (this.content[position] == null) {
            this.content[position] = newAluno;
            return;
        }
        if (this.content[position] instanceof HashTable) {
            HashTable newTable = (HashTable) this.content[position];
            newTable.add(newAluno);
            this.content[position] = newTable;
            return;
        }
        if (newAluno.equals((Aluno) this.content[position])) {
            return;
        }
        HashTable newTable = new HashTable(this.order - 1);
        newTable.add((Aluno) this.content[position]);
        newTable.add(newAluno);
    }

    public void add(Aluno newAluno) {
        int[] v = newAluno.getContent();
        int position = v[v.length - order];
        if (this.content[position] == null) {
            this.content[position] = newAluno;
            return;
        }
        if (this.content[position] instanceof HashTable) {
            HashTable newTable = (HashTable) this.content[position];
            newTable.add(newAluno);
            this.content[position] = newTable;
            return;
        }
        if (newAluno.equals((Aluno) this.content[position])) {
            return;
        }
        HashTable newTable = new HashTable(this.order - 1);
        newTable.add((Aluno) this.content[position]);
        newTable.add(newAluno);
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
}
