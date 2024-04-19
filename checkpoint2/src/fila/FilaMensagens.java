package fila;

import entidades.Mensagem;

public class FilaMensagens {
	public final int N = 10;
	Mensagem mensagem[] = new Mensagem[N];
	int ini, fim, cont;

	public void init() {
		ini = fim = cont = 0;
	}

	public boolean isEmpty() {
		return (cont == 0);
	}

	public boolean isFull() {
		return (cont == N);
	}

	public void enqueue(Mensagem elem) {
		if (isFull())
			System.out.println("Fila cheia!");
		else {
			mensagem[fim] = elem;
			fim = (fim + 1) % N;
			cont++;
		}
	}
	public Mensagem dequeue() {
		Mensagem elem = mensagem[ini];
		ini  = (ini+1)  % N;
		cont--;
		return elem;
	}

}
