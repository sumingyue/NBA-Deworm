package service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import service.TeamService;
import vo.TeamInfoVO;
import vo.TeamOppPerGameVO;
import vo.TeamOppTotalVO;
import vo.TeamPerGameVO;
import vo.TeamTotalVO;
import dao.TeamDao;
import dao.impl.DaoFactoryImpl;
import entity.OpponentStatsPerGame;
import entity.OpponentStatsTotal;
import entity.TeamInfo;
import entity.TeamStatsPerGame;
import entity.TeamStatsTotal;

/**
 * TeamService的具体实现
 * 
 * created by JaneLDQ on 2015年5月31日 下午8:27:03
 */
public class TeamServiceImpl extends UnicastRemoteObject implements TeamService {

	private static final long serialVersionUID = 1L;
	
	private TeamDao tdao;
	
	public TeamServiceImpl() throws RemoteException {
		super();
		tdao = DaoFactoryImpl.getDaoFactory().getTeamDao();
	}
	
	@Override
	public List<TeamTotalVO> getTeamTotalBySeason(String season)
			throws RemoteException {
		List<TeamTotalVO> volist = new ArrayList<TeamTotalVO>();
		List<TeamStatsTotal> list = tdao.getTeamTotalBySeason(season);
		for(TeamStatsTotal tst: list){
			TeamTotalVO vo = getTeamTotalToVO(tst);
			if(vo!=null)
				volist.add(vo);
		}
		return volist;
	}

	@Override
	public List<TeamPerGameVO> getTeamPerGameBySeason(String season)
			throws RemoteException {
		List<TeamPerGameVO> volist = new ArrayList<TeamPerGameVO>();
		List<TeamStatsPerGame> list = tdao.getTeamPerGameBySeason(season);
		for(TeamStatsPerGame tsp: list){
			TeamPerGameVO vo = getTeamPerGameVO(tsp);
			if(vo!=null)
				volist.add(vo);
		}
		return volist;
	}

	@Override
	public List<TeamOppTotalVO> getTeamOppTotalBySeason(String season)
			throws RemoteException {
		List<TeamOppTotalVO> volist = new ArrayList<TeamOppTotalVO>();
		List<OpponentStatsTotal> list = tdao.getTeamOppTotalBySeason(season);
		for(OpponentStatsTotal ost: list){
			TeamOppTotalVO vo = getOppTotalVO(ost);
			if(vo!=null)
				volist.add(vo);
		}
		return volist;
	}

	@Override
	public List<TeamOppPerGameVO> getTeamOppPerGameBySeason(String season)
			throws RemoteException {
		List<TeamOppPerGameVO> volist = new ArrayList<TeamOppPerGameVO>();
		List<OpponentStatsPerGame> list = tdao.getTeamOppPerGameBySeason(season);
		for(OpponentStatsPerGame osp: list){
			TeamOppPerGameVO vo = getOppPerGameVO(osp);
			if(vo!=null)
				volist.add(vo);
		}
		return volist;
	}

	@Override
	public List<TeamTotalVO> getTeamTotalByAbbr(String abbr)
			throws RemoteException {
		List<TeamTotalVO> volist = new ArrayList<TeamTotalVO>();
		List<TeamStatsTotal> list = tdao.getTeamTotalByAbbr(abbr);
		for(TeamStatsTotal tst: list){
			TeamTotalVO vo = getTeamTotalToVO(tst);
			if(vo!=null)
				volist.add(vo);
		}
		return volist;
	}

	@Override
	public List<TeamPerGameVO> getTeamPerGameByAbbr(String abbr)
			throws RemoteException {
		List<TeamPerGameVO> volist = new ArrayList<TeamPerGameVO>();
		List<TeamStatsPerGame> list = tdao.getTeamPerGameByAbbr(abbr);
		for(TeamStatsPerGame tsp: list){
			TeamPerGameVO vo = getTeamPerGameVO(tsp);
			if(vo!=null)
				volist.add(vo);
		}
		return volist;
	}

	@Override
	public List<TeamOppTotalVO> getTeamOppTotalByAbbr(String abbr)
			throws RemoteException {
		List<TeamOppTotalVO> volist = new ArrayList<TeamOppTotalVO>();
		List<OpponentStatsTotal> list = tdao.getTeamOppTotalByAbbr(abbr);
		for(OpponentStatsTotal ost: list){
			TeamOppTotalVO vo = getOppTotalVO(ost);
			if(vo!=null)
				volist.add(vo);
		}
		return volist;
	}

	@Override
	public List<TeamOppPerGameVO> getTeamOppPerGameByAbbr(String abbr)
			throws RemoteException {
		List<TeamOppPerGameVO> volist = new ArrayList<TeamOppPerGameVO>();
		List<OpponentStatsPerGame> list = tdao.getTeamOppPerGameByAbbr(abbr);
		for(OpponentStatsPerGame osp: list){
			TeamOppPerGameVO vo = getOppPerGameVO(osp);
			if(vo!=null)
				volist.add(vo);
		}
		return volist;
	}
	
	@Override
	public List<TeamInfoVO> getAllTeamInfo() throws RemoteException{
		List<TeamInfo> list = tdao.getAllTeamInfo();
		List<TeamInfoVO> volist = new ArrayList<TeamInfoVO>();
		for(TeamInfo info: list){
			TeamInfoVO vo = getInfoToVO(info);
			if(vo!=null)
				volist.add(getInfoToVO(info));
		}
		return volist;
	}

	private TeamInfoVO getInfoToVO(TeamInfo info) {
		if(info==null)
			return null;
		TeamInfoVO vo = new TeamInfoVO();
		vo.name = info.getName();
		vo.abbr = info.getAbbr();
		vo.buildup_time = info.getBuildup_time();
		vo.location = info.getLocation();
		vo.division = info.getDivision();
		vo.league = info.getLeague();
		vo.record = info.getRecord();
		vo.playeroff_appearance = info.getPlayeroff_appearance();
		return vo;
	}

	private TeamTotalVO getTeamTotalToVO(TeamStatsTotal tst) {
		if(tst==null)
			return null;
		TeamTotalVO vo = new TeamTotalVO();
		vo.abbr = tst.getAbbr();
		vo.season = tst.getSeason();
		vo.wins = tst.getWins();
		vo.losses = tst.getLosses();
		vo.finish = tst.getFinish();
		vo.age = tst.getAge();
		vo.height = tst.getHeight();
		vo.weight = tst.getWeight();
		vo.num_of_game = tst.getNum_of_game();
		vo.minute = tst.getMinute();
		vo.fg = tst.getFg();
		vo.fga = tst.getFga();
		vo.fga_pct = tst.getFga_pct();
		vo.fg3 = tst.getFg3();
		vo.fg3a = tst.getFg3a();
		vo.fg3_pct = tst.getFg3_pct();
		vo.fg2 = tst.getFg2();
		vo.fg2a = tst.getFg2a();
		vo.fg2_pct = tst.getFg2_pct();
		vo.ft = tst.getFt();
		vo.fta = tst.getFta();
		vo.ft_pct = tst.getFt_pct();
		vo.orb = tst.getOrb();
		vo.drb = tst.getDrb();
		vo.trb = tst.getTrb();
		vo.ast = tst.getAst();
		vo.stl = tst.getStl();
		vo.blk = tst.getBlk();
		vo.tov = tst.getTov();
		vo.pf = tst.getPf();
		vo.pts = tst.getPts();	
		return vo;
	}
	
	private TeamPerGameVO getTeamPerGameVO(TeamStatsPerGame tsp) {
		if(tsp==null)
			return null;
		TeamPerGameVO vo = new TeamPerGameVO();
		vo.abbr = tsp.getAbbr();
		vo.season = tsp.getSeason();
		vo.minute = tsp.getMinute();
		vo.fg = tsp.getFg();
		vo.fga = tsp.getFga();
		vo.fga_pct = tsp.getFga_pct();
		vo.fg3 = tsp.getFg3();
		vo.fg3a = tsp.getFg3a();
		vo.fg3_pct = tsp.getFg3_pct();
		vo.fg2 = tsp.getFg2();
		vo.fg2a = tsp.getFg2a();
		vo.fg2_pct = tsp.getFg2_pct();
		vo.ft = tsp.getFt();
		vo.fta = tsp.getFta();
		vo.ft_pct = tsp.getFt_pct();
		vo.orb = tsp.getOrb();
		vo.drb = tsp.getDrb();
		vo.trb = tsp.getTrb();
		vo.ast = tsp.getAst();
		vo.stl = tsp.getStl();
		vo.blk = tsp.getBlk();
		vo.tov = tsp.getTov();
		vo.pf = tsp.getPf();
		vo.pts = tsp.getPts();	
		return vo;
	}

	private TeamOppTotalVO getOppTotalVO(OpponentStatsTotal ost) {
		if(ost==null)
			return null;
		TeamOppTotalVO vo = new TeamOppTotalVO();
		vo.abbr = ost.getAbbr();
		vo.season = ost.getSeason();
		vo.num_of_game = ost.getNum_of_game();
		vo.minute = ost.getMinute();
		vo.fg = ost.getFg();
		vo.fga = ost.getFga();
		vo.fga_pct = ost.getFga_pct();
		vo.fg3 = ost.getFg3();
		vo.fg3a = ost.getFg3a();
		vo.fg3_pct = ost.getFg3_pct();
		vo.fg2 = ost.getFg2();
		vo.fg2a = ost.getFg2a();
		vo.fg2_pct = ost.getFg2_pct();
		vo.ft = ost.getFt();
		vo.fta = ost.getFta();
		vo.ft_pct = ost.getFt_pct();
		vo.orb = ost.getOrb();
		vo.drb = ost.getDrb();
		vo.trb = ost.getTrb();
		vo.ast = ost.getAst();
		vo.stl = ost.getStl();
		vo.blk = ost.getBlk();
		vo.tov = ost.getTov();
		vo.pf = ost.getPf();
		vo.pts = ost.getPts();	
		return vo;		
	}

	private TeamOppPerGameVO getOppPerGameVO(OpponentStatsPerGame osp) {
		if(osp==null)
			return null;
		TeamOppPerGameVO vo = new TeamOppPerGameVO();
		vo.abbr = osp.getAbbr();
		vo.season = osp.getSeason();
		vo.minute = osp.getMinute();
		vo.fg = osp.getFg();
		vo.fga = osp.getFga();
		vo.fga_pct = osp.getFga_pct();
		vo.fg3 = osp.getFg3();
		vo.fg3a = osp.getFg3a();
		vo.fg3_pct = osp.getFg3_pct();
		vo.fg2 = osp.getFg2();
		vo.fg2a = osp.getFg2a();
		vo.fg2_pct = osp.getFg2_pct();
		vo.ft = osp.getFt();
		vo.fta = osp.getFta();
		vo.ft_pct = osp.getFt_pct();
		vo.orb = osp.getOrb();
		vo.drb = osp.getDrb();
		vo.trb = osp.getTrb();
		vo.ast = osp.getAst();
		vo.stl = osp.getStl();
		vo.blk = osp.getBlk();
		vo.tov = osp.getTov();
		vo.pf = osp.getPf();
		vo.pts = osp.getPts();	
		return vo;
	}
	
}