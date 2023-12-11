package com.example.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.project.entity.TNoticeEntity;

@Repository
public interface TNoticeRepository extends JpaRepository<TNoticeEntity, Integer> {

	@Query(value = "SELECT\r\n"
			+ "    *\r\n"
			+ "FROM\r\n"
			+ "    t_notice n\r\n"
			+ "WHERE\r\n"
			+ "    n.termstudent =:termStudent\r\n"
			+ "    AND STR_TO_DATE(sdate, '%Y%m%d') <= STR_TO_DATE(:date, '%Y%m%d')\r\n"
			+ "    AND STR_TO_DATE(edate, '%Y%m%d') >= STR_TO_DATE(:date, '%Y%m%d')\r\n"
			+ "UNION ALL\r\n"
			// 期生がALLでランクが一致データ取得
			+ "SELECT\r\n"
			+ "    *\r\n"
			+ "FROM\r\n"
			+ "    t_notice n\r\n"
			+ "WHERE\r\n"
			+ "    n.termstudent =:allStudent\r\n"
			+ "    AND n.rank =:rank\r\n"
			+ "    AND STR_TO_DATE(sdate, '%Y%m%d') <= STR_TO_DATE(:date, '%Y%m%d')\r\n"
			+ "    AND STR_TO_DATE(edate, '%Y%m%d') >= STR_TO_DATE(:date, '%Y%m%d')\r\n"
			+ "UNION ALL\r\n"
			// 期生とランクがALLデータ取得
			+ "SELECT\r\n"
			+ "    *\r\n"
			+ "FROM\r\n"
			+ "    t_notice n\r\n"
			+ "WHERE\r\n"
			+ "    n.termstudent =:allStudent\r\n"
			+ "    AND n.rank =:allrank\r\n"
			+ "    AND STR_TO_DATE(sdate, '%Y%m%d') <= STR_TO_DATE(:date, '%Y%m%d')\r\n"
			+ "    AND STR_TO_DATE(edate, '%Y%m%d') >= STR_TO_DATE(:date, '%Y%m%d')\r\n"
			+ "    ORDER BY sdate Desc\r\n", nativeQuery = true)
	List<TNoticeEntity> findNotices(@Param("termStudent") String termStudent, @Param("allStudent") String allStudent,
			@Param("date") String date, @Param("rank") int rank, @Param("allrank") int allrank);

}
