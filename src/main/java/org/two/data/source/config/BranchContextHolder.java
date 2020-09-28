package org.two.data.source.config;

import org.two.data.source.constant.BranchEnum;

public class BranchContextHolder {

	private static ThreadLocal<BranchEnum> threadLocal = new ThreadLocal<>();

	public static void setBranchContext(BranchEnum branchEnum) {
		threadLocal.set(branchEnum);
	}

	public static BranchEnum getBranchContext() {
		return threadLocal.get();
	}

	public static void clearBranchContext() {
		threadLocal.remove();
	}
}