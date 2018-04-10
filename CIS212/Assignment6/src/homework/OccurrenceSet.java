package homework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OccurrenceSet<T> implements Set<T> {
	//create hashMap call data
	private HashMap<T, Integer> data = new HashMap<T, Integer>();

	@Override
	public boolean add(T e) {
		// TODO Auto-generated method stub
		if (data.containsKey(e))
		{
			Integer i = data.get(e);
			i++;
			data.put(e, i);
			return true;
		}
		else
		{
			data.put(e, new Integer(1));
			return true;			
		}
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		;
		// TODO Auto-generated method stub
		for(T item : c)
		{
			if (data.containsKey(item))
			{
				Integer i = data.get(item);
				data.put((T)item, i++);				
			}
			else
			{
				data.put((T) item, new Integer(1));
			}				
		}
		return true;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this.data = new HashMap<T, Integer>();
		
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return data.containsKey(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return data.keySet().containsAll(c);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return data.isEmpty();
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		Iterator<T> iterator = data.keySet().iterator();
		ArrayList<T> arrayList = new ArrayList<T>();
		if (iterator.hasNext())
		{
			T input = iterator.next();
			arrayList.add(input);				
		}
		return arrayList.iterator();
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return data.keySet().remove(o);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return data.keySet().removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return data.keySet().retainAll(c);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return sortData(data).toArray();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return sortData(data).toString();
	}

	@SuppressWarnings({ "hiding", "unchecked" })
	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return ((T[]) sortData(data).toArray());
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private LinkedList<Object> sortData(Map<T, Integer> map){
		LinkedList dataList = new LinkedList(data.entrySet());
		LinkedList<Object> sort = new LinkedList<Object>();
		Collections.sort((List<T>) dataList, new Comparator<Object>() 
		{
			public int compare(Object o1, Object o2)
			{
				if (((Comparable<Integer>) ((Map.Entry<T, Integer>) (o1)).getValue())
						.compareTo(((Map.Entry<T, Integer>) (o2)).getValue()) > 0) 
				{
					return 1;
				} 
				if (((Comparable<Integer>) ((Map.Entry<T, Integer>) (o1)).getValue())
						.compareTo(((Map.Entry<T, Integer>) (o2)).getValue()) < 0) 
				{
					return -1;
				} 
				else 
				{
					return 0;
				}
		     }
		});
		
		for (Iterator<T> iterate = dataList.iterator(); iterate.hasNext();) {
			// return data was sorted
			Map.Entry entry = (Map.Entry) iterate.next();
			sort.add(entry.getKey());
		}
		return sort;

		
	}

}
