package dao;

import java.util.List;

import entity.PlayerInfo;
import entity.PlayerSalary;
import entity.PlayerStatsAdvanced;
import entity.PlayerStatsPerGame;
import entity.PlayerStatsTotal;

/**
 * 球员数据Dao抽象接口
 * 
 * created by JaneLDQ on 2015年5月28日 下午6:59:16
 */
public interface PlayerDao {
	
	/**
	 * 根据名字首字母获得球员信息
	 * @param initial 首字母A-Z
	 */
	public List<PlayerInfo> getPlayerInfoByNameInitial(String initial);
	
	/**
	 * 获取单个球员基本信息
	 * @param name 姓名
	 * @return
	 */
	public PlayerInfo getPlayerInfoByName(String name);
	
	/**
	 * 获取单个球员所有赛季的总数据
	 * @param name 球员姓名
	 * @return
	 */
	public List<PlayerStatsTotal> getPlayerTotalByName(String name);
	
	/**
	 * 获取单个球员所有赛季的场均数据
	 * @param name 球员姓名
	 * @return
	 */
	public List<PlayerStatsPerGame> getPlayerPerGameByName(String name);
	
	/**
	 * 获取单个球员所有赛季的高阶数据
	 * @param name 球员姓名
	 * @return
	 */
	public List<PlayerStatsAdvanced> getPlayerAdvancedByName(String name);
	
	/**
	 * 获得单个球员每赛季的薪水列表
	 * @param name
	 * @return
	 */
	public List<PlayerSalary> getPlayerSalaryByName(String name);
	
	/**
	 * 获取单赛季的所有球员总数据
	 * @param season 赛季
	 * @return
	 */
	public List<PlayerStatsTotal> getPlayerTotalBySeason(String season);
	
	/**
	 * 获取单个赛季的所有球员场均数据
	 * @param season 赛季
	 * @return
	 */
	public List<PlayerStatsPerGame> getPlayerPerGameBySeason(String season);
	
	/**
	 * 获取单个赛季所有球员的高阶数据
	 * @param season 赛季
	 * @return
	 */
	public List<PlayerStatsAdvanced> getPlayerAdvancedBySeason(String season);
	
	/**
	 * 插入球员基本信息
	 */
	public void insertPlayerInfo(List<PlayerInfo> list);
	
	/**
	 * 插入球员薪水列表
	 */
	public void insertPlayerSalary(List<PlayerSalary> list);
	
	/**
	 * 插入球员总数据
	 */
	public void insertPlayerTotal(List<PlayerStatsTotal> list);
	
	/**
	 * 插入球员场均数据
	 */
	public void insertPlayerPerGame(List<PlayerStatsPerGame> list);
	
	/**
	 * 插入球员高阶数据
	 */
	public void insertPlayerAdvanced(List<PlayerStatsAdvanced> list);
	
}