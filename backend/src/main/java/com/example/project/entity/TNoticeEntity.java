package com.example.project.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * お知らせテーブルのエンティティ
 */

@Entity
@Getter
@Setter
@Table(name = "t_notice")
public class TNoticeEntity {

	/**
	 * お知らせID
	 **/
	@Id
	@Column(name = "noticeid")
	private Integer noticeId;

	/**
	 * 期生
	 **/
	@Column(name = "termstudent")
	private String termStudent;

	/**
	 * ランク
	 **/
	@Column(name = "rank")
	private Integer rank;

	/**
	 * 適用開始日
	 **/
	@Column(name = "sdate")
	private String sDate;

	/**
	 * 適用終了日
	 **/
	@Column(name = "edate")
	private String eDate;

	/**
	 * タイトル
	 **/
	@Column(name = "title")
	private String title;

	/**
	 * メッセージ
	 **/
	@Column(name = "message")
	private String message;

	/**
	 * 登録者ID
	 **/
	@Column(name = "creatorid")
	private String creatorId;

	/**
	 * 登録日時
	 **/
	@Column(name = "createdate")
	private Date createDate;

	/**
	 * 更新者ID
	 **/
	@Column(name = "updaterid")
	private String updaterId;

	/**
	 * 更新日時
	 **/
	@Column(name = "updatedate")
	private Date updateDate;

	/**
	 * お知らせIDを取得
	 */
	public Integer getNoticeId() {
		return noticeId;
	}

	/**
	 * お知らせIDをセット
	 */
	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}

	/**
	 * 期生を取得
	 */
	public String getTermStudent() {
		return termStudent;
	}

	/**
	 * 期生をセット
	 */
	public void setTermStudent(String termStudent) {
		this.termStudent = termStudent;
	}

	/**
	 * ランクを取得
	 */
	public Integer getRank() {
		return rank;
	}

	/**
	 * ランクをセット
	 */
	public void setRank(Integer rank) {
		this.rank = rank;
	}

	/**
	 * 適用開始日を取得
	 */
	public String getSDate() {
		return sDate;
	}

	/**
	 * 適用開始日をセット
	 */
	public void setSDate(String sDate) {
		this.sDate = sDate;
	}

	/**
	 * 適用終了日を取得
	 */
	public String getEDate() {
		return eDate;
	}

	/**
	 * 適用終了日をセット
	 */
	public void setEDate(String eDate) {
		this.eDate = eDate;
	}

	/**
	 * タイトルを取得
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * タイトルをセット
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * メッセージを取得
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * メッセージをセット
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 登録者IDを取得
	 */
	public String getCreatorId() {
		return creatorId;
	}

	/**
	 * 登録者IDをセット
	 */
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	/**
	 * 登録日時を取得
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 登録日時をセット
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 更新者IDを取得
	 */
	public String getUpdaterId() {
		return updaterId;
	}

	/**
	 * 更新者IDをセット
	 */
	public void setUpdaterId(String updaterId) {
		this.updaterId = updaterId;
	}

	/**
	 * 更新日時を取得
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * 更新日時をセット
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}