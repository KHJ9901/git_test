package com.plant.dao;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.plant.common.OracleConn;
import com.plant.dto.*;

public class MemInfoDao {
	private final Connection conn = OracleConn.getInstance().getConn();
	
	public List<MemInfo> myboard(String id) {

		List<MemInfo> meminfo = new ArrayList<MemInfo>();
		System.out.println("아이디 : " + id);
		
		String sql = " select rownum, z.seqno as seqno, z.title as title, z.wdate as wdate,  z.id as id, z.count as count";
			  sql += " from(select b.seqno, b.title, b.wdate, b.id, b.count";
			  sql += " from board b, members m";
			  sql += " where b.id = m.id) z";
			  sql += " where z.id = ?";
			  PreparedStatement stmt;
			  
		  	  try {
				  stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
												  ResultSet.CONCUR_UPDATABLE);
				  stmt.setString(1, id);
				  //stmt.setString(2, id);
				  
				  ResultSet rs = stmt.executeQuery();
				  System.out.println("sql : " + sql);
				  MemInfo b = null;
				  while(rs.next()) {
				  	  b = new MemInfo();
				  	  System.out.println("나와라" + rs.getString("title"));
				  	  System.out.println("카운트가 안나와요" + rs.getString("count"));
					  b.setNo(rs.getString("rownum"));
						/* b.setSeqno(rs.getString("seqno")); */
					  b.setSeqno(rs.getString("seqno"));
					  b.setTitle(rs.getString("title"));
					  b.setWdate(rs.getString("wdate"));
						/* b.setName(rs.getString("name")); */
					  b.setId(rs.getString("id"));
					  b.setCount(rs.getString("count"));
					  meminfo.add(b);
				  }
				} catch (SQLException e) {	
					e.printStackTrace();
				}
		  	  	System.out.println("하이염");
			  	return meminfo;
	}
	public List<MemInfo> myqnaboard(String id) {
		
		List<MemInfo> board = new ArrayList<MemInfo>();
		System.out.println("아이디 : " + id);
		
		String sql = " select rownum, z.seqno as seqno, z.content as content, z.wdate as wdate, z.id as id, z.count as count";
		sql += " from(select q.seqno, q.content, q.count, q.wdate, q.id";
		sql += " from qna q, members m";
		sql += " where q.id = m.id)z";
		sql += " where z.id = ?";
		PreparedStatement stmt;
		
		try {
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1, id);
			//stmt.setString(2, id);
			
			ResultSet rs = stmt.executeQuery();
			MemInfo b = null;
			while(rs.next()) {
				b = new MemInfo();
				System.out.println("제목님아 나오셈" +rs.getString("content"));
				b.setNo(rs.getString("rownum"));
				b.setSeqno(rs.getString("seqno"));
				b.setContent(rs.getString("content"));
				b.setWdate(rs.getString("wdate"));
				b.setId(rs.getString("id"));
				b.setCount(rs.getString("count"));
				board.add(b);
			}
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return board;
	}
	public List<MemInfo> myadoptboard(String id) {
		
		List<MemInfo> board = new ArrayList<MemInfo>();
		System.out.println("아이디 : " + id);
		
		String sql = " select rownum, z.seqno as seqno, z.content as content, z.wdate as wdate, z.id as id, z.count as count";
		sql += " from(select a.seqno, a.content, a.count, a.wdate, a.id";
		sql += " from adopt a, members m";
		sql += " where a.id = m.id)z";
		sql += " where z.id = ?";
		PreparedStatement stmt;
		
		try {
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1, id);
			//stmt.setString(2, id);
			
			ResultSet rs = stmt.executeQuery();
			MemInfo b = null;
			while(rs.next()) {
				b = new MemInfo();
				b.setNo(rs.getString("rownum"));
				b.setSeqno(rs.getString("seqno"));
				b.setContent(rs.getString("content"));
				b.setWdate(rs.getString("wdate"));
				b.setId(rs.getString("id"));
				b.setCount(rs.getString("count"));
				board.add(b);
			}
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return board;
	}
	public List<MemInfo> myadoptreviewboard(String id) {
		
		List<MemInfo> board = new ArrayList<MemInfo>();
		System.out.println("아이디 : " + id);
		
		String sql = " select rownum, z.seqno as seqno, z.content as content, z.wdate as wdate, z.id as id, z.count as count";
		sql += " from(select ar.seqno, ar.content, ar.count, ar.wdate, ar.id";
		sql += " from adopt_review ar, members m";
		sql += " where ar.id = m.id)z";
		sql += " where z.id = ?";
		PreparedStatement stmt;
		
		try {
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1, id);
			//stmt.setString(2, id);
			
			ResultSet rs = stmt.executeQuery();
			MemInfo b = null;
			while(rs.next()) {
				b = new MemInfo();
				b.setNo(rs.getString("rownum"));
				b.setSeqno(rs.getString("seqno"));
				b.setContent(rs.getString("content"));
				b.setWdate(rs.getString("wdate"));
				b.setId(rs.getString("id"));
				b.setCount(rs.getString("count"));
				board.add(b);
			}
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return board;
	}
	public List<MemInfo> myplantboard(String id) {
		
		List<MemInfo> board = new ArrayList<MemInfo>();
		System.out.println("아이디 : " + id);
		
		String sql = " select rownum, z.mplant_seqno as seqno, z.etc as etc, z.wdate as wdate, z.id as id, z.count as count";
		sql += " from(select mp.mplant_seqno, mp.etc, mp.count, mp.wdate, mp.id";
		sql += " from mplant mp, members m";
		sql += " where mp.id = m.id)z";
		sql += " where z.id = ?";
		PreparedStatement stmt;
		
		try {
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1, id);
			//stmt.setString(2, id);
			
			ResultSet rs = stmt.executeQuery();
			MemInfo b = null;
			while(rs.next()) {
				b = new MemInfo();
				//System.out.println("이티씨 나오셈" +rs.getString("etc"));
				b.setNo(rs.getString("rownum"));
				b.setSeqno(rs.getString("seqno"));
				b.setEtc(rs.getString("etc"));
				b.setWdate(rs.getString("wdate"));
				b.setId(rs.getString("id"));
				b.setCount(rs.getString("count"));
				board.add(b);
			}
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return board;
	}
	public List<MemInfo> myreply(String id) {
		
		List<MemInfo> board = new ArrayList<MemInfo>();
		System.out.println("아이디 : " + id);
		
		String sql = " select rownum, z.seqno as seqno, z.title as title, z.count as count, z.wdate as wdate, z.id as id";
		sql += " from(select b.seqno,b.title, b.count, b.wdate, b.id";
		sql += " from board b, board_reply br, members m";
		sql += " where b.seqno = br.seqno";
		sql += " and br.id = m.id)z";
		sql += " where z.id = ?";
		PreparedStatement stmt;
		
		try {
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1, id);
			//stmt.setString(2, id);
			
			ResultSet rs = stmt.executeQuery();
			MemInfo b = null;
			while(rs.next()) {
				b = new MemInfo();
				//System.out.println("이티씨 나오셈" +rs.getString("etc"));
				b.setNo(rs.getString("rownum"));
				b.setSeqno(rs.getString("seqno"));
				b.setTitle(rs.getString("title"));
				b.setWdate(rs.getString("wdate"));
				b.setId(rs.getString("id"));
				b.setCount(rs.getString("count"));
				board.add(b);
			}
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return board;
	}
	public List<MemInfo> myqnareplyboard(String id) {
		
		List<MemInfo> board = new ArrayList<MemInfo>();
		System.out.println("아이디 : " + id);
		String sql = " select rownum, z.seqno as seqno, z.content as content, z.count as count, z.wdate as wdate, z.id as id";
		sql += " from(select q.seqno,q.content, q.count, q.wdate, q.id";
		sql += " from qna q, qna_reply qr, members m";
		sql += " where q.seqno = qr.seqno";
		sql += " and q.seqno = qr.seqno)z";
		sql += " where z.id = ?";
		PreparedStatement stmt;
		
		try {
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1, id);
			//stmt.setString(2, id);
			
			ResultSet rs = stmt.executeQuery();
			MemInfo b = null;
			while(rs.next()) {
				b = new MemInfo();
				//System.out.println("이티씨 나오셈" +rs.getString("etc"));
				b.setNo(rs.getString("rownum"));
				b.setSeqno(rs.getString("seqno"));
				b.setContent(rs.getString("content"));
				b.setWdate(rs.getString("wdate"));
				b.setId(rs.getString("id"));
				b.setCount(rs.getString("count"));
				board.add(b);
			}
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return board;
	}

	public Plantmember mypage(String id) {
		
		Plantmember member = new Plantmember();
		
		try {
			String sql 	= "SELECT nickname, wdate, email, phone, "
					+ 	" ( "
					+ 	"	    (SELECT count(b.content) FROM board b WHERE b.id = ?) + "
					+	"	    (SELECT count(a.content) FROM adopt a WHERE a.id = ?) + "
					+	"	    (SELECT count(ar.content) FROM adopt_review ar  WHERE ar.id = ?) + "
					+	"    (SELECT count(q.content) FROM qna q WHERE q.id = ?) + "
					+	"	    (SELECT count(mp.id) FROM mplant mp WHERE mp.id = ?) "
					+	" ) as count, "
					+	"	( "
					+	"	    (SELECT count(br.content) FROM board_reply br, members m WHERE br.id= ?) + "
					+	"	    (SELECT count(qr.content) FROM qna_reply qr, members m WHERE qr.id= ?) "
					+	"	) as reply "
					+	"	FROM members "
					+	"	WHERE id = ?";
			
			System.out.println(sql);
			PreparedStatement stmt;
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, id);
			stmt.setString(3, id);
			stmt.setString(4, id);
			stmt.setString(5, id);
			stmt.setString(6, id);
			stmt.setString(7, id);
			stmt.setString(8, id);
			//stmt.setString(2, id);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				//System.out.println("이티씨 나오셈" +rs.getString("etc"));
				member.setNickname(rs.getString("nickname"));
				member.setWdate(rs.getString("wdate"));
				member.setEmail(rs.getString("email"));
				member.setPhone(rs.getString("phone"));
				member.setCount(rs.getString("count"));
				member.setReply(rs.getString("reply"));
				
			}
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return member;
	}
	
	public MemInfo boardDetail(String seqno) {
		
		MemInfo board = new MemInfo();
		
		try {
			//조회수
			String sql = "update qna set count = count+1 where seqno ="  + seqno;
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
			
			//게시물 세부내용
			sql = " select seqno, title, content, id,";
			sql +="	To_char(b.wdate, 'YYYY-MM-DD(DY) HH:MI:SS PM') wdate,";
			sql +=" count, (select name from members m where m.id = b.id) name"; 
			sql +="	from board b";
			sql +="	where b.seqno = ?";
			sql +="	union all";
		    sql +="	select br_seqno, '', content, id,";
			sql +=" TO_CHAR(r.wdate, 'YYYY-MM-DD(DY) HH:MI:SS PM') wdate,";
			sql +=" 0, (select name from members m where m.id = r.id) name";
			sql +="	from board_reply r";
			sql +="	where r.seqno = ?";
			sql +="	union all";
			sql +="	select bi_seqno, '', '', '', '', 0, ''";
			sql +="	from board_img i";
			sql +="	where i.seqno = ?";
			
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1, seqno);
			stmt.setString(2, seqno);
			stmt.setString(3, seqno);
			ResultSet rs = stmt.executeQuery();
			
			rs.next();
			
			board.setSeqno(seqno);
			board.setTitle(rs.getString("title"));
			board.setContent(rs.getString("content"));
			board.setId(rs.getString("id"));
			board.setWdate(rs.getString("wdate"));
			board.setCount(rs.getString("count"));
			board.setName(rs.getString("name"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return board;
	}
}