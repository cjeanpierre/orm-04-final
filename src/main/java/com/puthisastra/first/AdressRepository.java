package com.puthisastra.first;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdressRepository extends JpaRepository<Adress, Long> {

	List<Adress> findByCityAndCountry(String city, String country);
	
	List<Adress> findByCityOrCountry(String city, String country);
	
	List<Adress> findByCityIgnoreCase(String city);
	
	List<Adress> findByCityOrderByCityAsc(String city);
	
	List<Adress> findByCityOrderByCountryDesc(String city);
	
	Adress findFirstByOrderByCountryAsc();
	
	Adress findTopByOrderByCountryAsc();
	
	List<Adress> findTop3ByOrderByCountryDesc();
	
	List<Adress> findByNumberLessThan(Integer number);
	
	List<Adress> findByNumberLessThanEqual(Integer number);
	
	List<Adress> findByNumberGreaterThan(Integer number);
	
	List<Adress> findByNumberGreaterThanEqual(Integer number);
	
	List<Adress> findByNumberBetween(Integer number1, Integer number2);
	
	List<Adress> findByNumberIsNull();
	
	List<Adress> findByNumberIsNotNull();
	
	List<Adress> findByCountryLike(String country);
	
	List<Adress> findByCountryNotLike(String country);
	
	@Query("select a from Adress a where a.country = ?1")
	List<Adress> findByCountryQuery(String country);
	
	@Query("select a from Adress a where a.country like concat(?1, '%')")
	List<Adress> findByCountryQueryLike(String country);
	
	@Query("select a from Adress a where a.country = :country and a.name = :name")
	List<Adress> findByCountryAndName(@Param("country") String country,
	                                 @Param("name") String name);
	
	@Query("select MAX(a.number) from Adress a")
	Integer findByNumberQueryMax();
	
	@Query("select MIN(a.number) from Adress a")
	Integer findByNumberQueryMin();
	
	@Query("select count(*) from Adress a where a.country = :country")
	Integer findByNumberQueryCount(String country);
	
	@Query("select sum(a.number) from Adress a where a.country = :country")
	Integer findByNumberQuerySum(String country);
	
	@Query("select a from Adress a order by a.country desc")
	List<Adress> findByCountryQuerySort();
	
	@Query("select a from Adress a")
	List<Adress> findByCountryQuerySort(Sort sort);
	
	@Modifying
	@Transactional
	@Query("update Adress a set a.name = ?1 where a.number = ?2")
	int setName(String name, Integer number);
	
	@Modifying
	@Transactional
	@Query("delete from Adress a where a.number = ?1")
	void deleteByNumber(Integer number);
	
	@Query(value = "SELECT * FROM ADRESS WHERE COUNTRY = ?1", nativeQuery = true)
	List<Adress> findByCountryNativeQuery(String country);
}
