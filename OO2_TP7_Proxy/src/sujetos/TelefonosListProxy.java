package sujetos;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import accesos.PersonaDao;
import modelo.Telefono;

public class TelefonosListProxy implements Set<Telefono> {

	Set<Telefono> telefonos;
	private int personaID;

	public TelefonosListProxy(int id) {
		this.personaID = id;
		this.telefonos = new HashSet<Telefono>();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<Telefono> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T[] toArray(T[] a) {
		PersonaDao persona = new PersonaDao();
		this.telefonos = persona.telefonosPorId(this.personaID);
		return (T[]) telefonos.toArray(new Telefono[telefonos.size()]);

	}

	@Override
	public boolean add(Telefono e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Telefono> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

//	TelefonoList sujetoReal;

//	public Telefono[] telefonos(int id) {
//		if (sujetoReal == null) {
//			System.out.println("Creando la lista de telefonos reales..");
//			sujetoReal = new TelefonosListReal();
//		}
//		return sujetoReal.telefonos(id);
//	}

}