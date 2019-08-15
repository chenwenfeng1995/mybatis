package dao;

import java.util.List;

import Entity.Emp;

public interface IEmpDao {

	public List<Emp> selectEnmpAll();
	
	public List<Emp> findbyid(Integer empno);
	
	public boolean inser(Emp  emp);
}
