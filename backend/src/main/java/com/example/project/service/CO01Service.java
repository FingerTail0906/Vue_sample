package com.example.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.project.bean.CO0TableBean;
import com.example.project.entity.TNoticeEntity;
import com.example.project.form.CO01Form;
import com.example.project.repository.TNoticeRepository;

@Service
public class CO01Service {

	@Autowired
	TNoticeRepository tNoticeRepository;

	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	// 全件取得
	public List<TNoticeEntity> getTNoticeList() {
		return tNoticeRepository.findAll();
	}

	// 検索処理
	public List<CO0TableBean> getSearch(CO01Form form) {

		String sql = "SELECT tn.noticeid, \r\n"
				+ "        tn.termstudent, \r\n"
				+ "        tn.rank, \r\n"
				+ "        tn.sdate, \r\n"
				+ "        tn.edate, \r\n"
				+ "        tn.title, \r\n"
				+ "        tn.message \r\n"
				+ "FROM t_notice AS tn \r\n";

		// WHERE句
		List<String> where = new ArrayList<String>();
		if (StringUtils.hasText(form.getSearchKeyWord())) {
			where.add("tn.title LIKE :title");
		}

		if (StringUtils.hasText(form.getSelectA())) {
			where.add("tn.rank = :rank");
		}

		if (StringUtils.hasText(form.getSelectB())) {
			where.add("tn.termstudent = :termstudent");
		}

		if (!where.isEmpty()) {
			sql += " WHERE " + StringUtils.collectionToDelimitedString(where, " AND ");
		}
		SqlParameterSource parameters = new MapSqlParameterSource()
				.addValue("title", "%" + form.getSearchKeyWord() + "%")
				.addValue("rank", form.getSelectA())
				.addValue("termstudent", form.getSelectB());

		List<Map<String, Object>> result = jdbcTemplate.queryForList(sql, parameters);

		List<CO0TableBean> list = new ArrayList<CO0TableBean>();
		for (Map<String, Object> row : result) {
			CO0TableBean rowSet = new CO0TableBean();
			rowSet.setNoticeid(row.get("noticeid").toString());
			rowSet.setTermstudent(row.get("termstudent").toString());
			rowSet.setRank(row.get("rank").hashCode());
			rowSet.setSdate(row.get("sdate").toString());
			rowSet.setEdate(row.get("edate").toString());
			rowSet.setTitle(row.get("title").toString());
			rowSet.setMessage(row.get("message").toString());
			list.add(rowSet);
		}

		return list;

	}
}
