package com.ams.assetmanage.assetinf.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ams.assetmanage.assetinf.entity.Assetinf;
import com.ams.assetmanage.assetinf.model.AssetinfModel;
import com.ams.assetmanage.assetinf.service.AssetinfService;
import com.ams.assetmanage.assetnam.entity.Assetnam;
import com.ams.assetmanage.assetnam.service.AssetnamService;
import com.ams.infomanage.factory.entity.Factory;
import com.ams.infomanage.factory.service.FactoryService;
import com.ams.infomanage.maintenanceinfo.entity.Maintenanceinfo;
import com.ams.infomanage.maintenanceinfo.service.MaintenanceinfoService;
import com.ams.infomanage.project.entity.Project;
import com.ams.infomanage.project.service.ProjectService;
import com.ams.infomanage.supplier.entity.Supplier;
import com.ams.infomanage.supplier.service.SupplierService;
import com.ams.system.entity.User;
import com.ams.system.model.UserModel;
import com.ams.system.service.UserService;
import com.core.action.BaseAction;
import com.core.model.OutputMessage;
import com.util.enums.PageSizeEnum;
import com.util.json.JackJsonUtils;
import com.util.page.Pager;
import com.util.page.PagerHelper;

/**
 * 资产管理
 * 
 * @author zyy
 * @Data 
 * 
 */
@Controller
public class AssetinfAction extends BaseAction {
	private static final long serialVersionUID = 96172069305589029L;
	@Resource
	private AssetinfService assetinfService;
	@Resource
	private AssetnamService assetnamService;
	@Resource
	private FactoryService factoryService;
	@Resource
	private SupplierService supplierService;
	@Resource 
	private ProjectService projectService;
	@Resource
	private MaintenanceinfoService maintenanceinfoService;
	@Resource 
	private UserService userService;
	/**
	 * 跳转到新建页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/assetmanage/assetinf/add")
	public String add(ModelMap map) {
		List<Assetnam> assetnamList=assetnamService.findByCondition(new Assetnam(),	null);
		map.addAttribute("assetnamList",assetnamList);
		List<Factory> facotryList=factoryService.findByCondition(new Factory(), null);
		map.addAttribute("facotryList", facotryList);
		List<Supplier> supplierList=supplierService.findByCondition(new Supplier(), null);
		map.addAttribute("supplierList", supplierList);
		List<Project> projectList=projectService.findByCondition(new Project(), null);
		map.addAttribute("projectList",projectList);
		List<Maintenanceinfo> maintenanceinfoList=maintenanceinfoService.findByCondition(new Maintenanceinfo(), null);
		map.addAttribute("maintenanceinfoList",maintenanceinfoList);
		//日期
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		map.addAttribute("now_time", df.format(new Date()));		
		List<User> userList=userService.findByCondition(new UserModel(), null);
		map.addAttribute("userList", userList);
		return ASSETINF + "edit"; // AMS/assetinf/edit.jsp
	}

	/**
	 * 保存
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/assetmanage/assetinf/save", produces = "text/plain;charset=UTF-8")
	public @ResponseBody
	String save(Assetinf model) {
		OutputMessage msg = new OutputMessage();
		if (null != model) {
			if (StringUtils.isNotEmpty(model.getassetId())) {// 修改
				Assetinf assetinf = assetinfService.getById(model.getassetId());
				if (null != assetinf) {
					assetinfService.update(model);
					msg = setOutputMessage(true, "修改成功！", model.getassetId());
				} else {
					msg = setOutputMessage(false, "该资产已经被删除！",
							model.getassetId());
				}
			} else {// 保存
				if(assetinfService.save(model)!=null){
					msg = setOutputMessage(true, "新建成功！", model.getassetId());
				}else {
					msg = setOutputMessage(false, "新建失败！", model.getassetId());
				}
			}
		} else {
			msg = setOutputMessage(false, "数据为空", null);
		}
		return JackJsonUtils.toJSon(msg);
	}

	/**
	 * 跳转到编辑页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/assetmanage/assetinf/edit")
	public String edit(String id, ModelMap map) {
		List<Assetnam> assetnamList=assetnamService.findByCondition(new Assetnam(),	null);
		map.addAttribute("assetnamList",assetnamList);
		List<Factory> facotryList=factoryService.findByCondition(new Factory(), null);
		map.addAttribute("facotryList", facotryList);
		List<Supplier> supplierList=supplierService.findByCondition(new Supplier(), null);
		map.addAttribute("supplierList", supplierList);
		List<Project> projectList=projectService.findByCondition(new Project(), null);
		map.addAttribute("projectList",projectList);
		List<Maintenanceinfo> maintenanceinfoList=maintenanceinfoService.findByCondition(new Maintenanceinfo(), null);
		map.addAttribute("maintenanceinfoList",maintenanceinfoList);
		if (StringUtils.isNotEmpty(id)) {
			Assetinf model = assetinfService.getById(id);
			map.addAttribute("model", model);
			return ASSETINF + "edit";
		} else {
			this.returnException("资产编号不存在，不能编辑！");
		}
		return ERROR;

	}

	/**
	 * 跳转到详细页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/assetmanage/assetinf/detail")
	public String detail(String id, ModelMap map) {
		if (StringUtils.isNotEmpty(id)) {
			AssetinfModel model = assetinfService.getModelById(id);
			map.addAttribute("model", model);
			return ASSETINF + "detail";
		} else {
			this.returnException("资产编码不存在，查看不了详细！");
		}
		return ERROR;
	}

	/**
	 * 物理删除资产信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/assetmanage/assetinf/delete", produces = "text/plain;charset=UTF-8")
	public @ResponseBody
	String delete(String id) {
		OutputMessage msg = new OutputMessage();
		if (StringUtils.isNotEmpty(id)) {
			assetinfService.delete(id);
			msg = setOutputMessage(true, "操作成功！", id);
		} else {
			msg = setOutputMessage(false, "操作失败", id);
		}
		return JackJsonUtils.toJSon(msg);
	}

	/**
	 * 跳转到列表页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/assetmanage/assetinf/toList")
	public String toList(ModelMap map) {
		List<Assetnam> assetnamList=assetnamService.findByCondition(new Assetnam(), null);
		map.addAttribute("assetnamList", assetnamList);
		return ASSETINF + "list";
	}

	/**
	 * 局部刷新翻页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/assetmanage/assetinf/list", produces = "text/plain;charset=UTF-8")
	public @ResponseBody
	String list(AssetinfModel model) {
		Pager page = PagerHelper.getInstance(this.getRequest(),
				PageSizeEnum.MIDDLE);
		List<AssetinfModel> list = assetinfService.findModelByCondition(model, page);
		page.setRows(list);
		return JackJsonUtils.toJSon(page);
	}

	/**
	 * 打开弹出框内容
	 * 
	 * @return
	 */
	@RequestMapping(value = "/assetmanage/assetinf/toPopList")
	public String toPopList(Assetinf model, ModelMap map) {
		map.addAttribute("model", model);
		return ASSETINF + "assetinfPop";
	}

	/**
	 * 弹出框局部刷新
	 */
	@RequestMapping(value = "/assetmanage/assetinf/popList", produces = "text/plain;charset=UTF-8")
	public @ResponseBody
	String popList(Assetinf model) {
		Pager page = PagerHelper.getInstance(this.getRequest(),
				PageSizeEnum.MIDDLE);
		List<Assetinf> list = assetinfService.findByCondition(model, page);
		page.setRows(list);
		return JackJsonUtils.toJSon(page);
	}

	/**
	 * 检查资产名id是否存在
	 * 
	 * @param id
	 * @return
	 *//*
	@RequestMapping(value = "/assetmanage/assetinf/checkAssetinf", produces = "text/plain;charset=UTF-8")
	public @ResponseBody
	String checkAssetinf( String id) {
		boolean flag = false;
		flag = assetinfService.checkAssetinf( id);
		return String.valueOf(flag);
	}*/

}
