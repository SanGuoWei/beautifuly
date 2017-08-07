/**
 * Copyright (c) 2015-2016, Silly Boy 胡建洪(1043244432@qq.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jie.controllers;

import com.jie.BaseController;

public class MainController extends BaseController {
	/**
	 * @Description 跳转到index页面
	 * @auth weishujie
	 * @creattime 2017年8月4日下午5:32:33
	 */
	public void index() {
		redirect("/front/index.jsp");
	}
}
