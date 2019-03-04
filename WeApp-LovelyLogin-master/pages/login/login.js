Page({
  data: {
    userName: '',
    userPassword: '',
    province:'',
    city: '',
    sex: '',
  },
  onLoad: function (e) {
  },
  pwdFocus() {
    this.setData({
      inputPassword: true
    })
  },
  pwdBlur() {
    this.setData({
      inputPassword: false
    })
  },

  userNameInput: function (e) {
    this.setData({
      userName: e.detail.value
    })
  },
  userPasswordInput: function (e) {
    this.setData({
      userPassword: e.detail.value
    })
  },

  bindIdentity: function () {
    var that = this
    //得到用户信息
    wx.getUserInfo({
      success: function (res) {
        // success
        //nickName: res.userInfo.nickName,
        getApp().globalData.headimg=res.userInfo.avatarUrl,
        getApp().globalData.map = res.userInfo.city
        switch (res.userInfo.gender) {
          case 0:
            getApp().globalData.sex = '未知';
            break;
          case 1:
            getApp().globalData.sex = '男';
            break;
          case 2:
            getApp().globalData.sex = '女';
            break;
        }
      },
      fail: function () {
        // fail
        console.log("获取失败！")
      },
      complete: function () {
        // complete
        console.log("获取用户信息完成！")
      }
    })
    var id = this.data.userName;
    var pwd = this.data.userPassword;
    wx.request({
      url: 'https://www.zyserverfordevelop.cn/healthcloud/user/login.do',
      data: {
        id: this.data.userName,
        pwd: this.data.userPassword,
      },
      method: 'GET',
      success: function (res) {
        wx.showToast({
          title: '登录成功',
          icon: 'success',
          duration: 800
        });
        getApp().globalData.id = id;
        getApp().globalData.pwd = pwd;
        getApp().globalData.user_id = res.data.json[0].user_id;
        getApp().globalData.tem = res.data.json[0].tem;
        getApp().globalData.user_tem = res.data.json[0].user_tem;
        getApp().globalData.user_press_l = res.data.json[0].user_press_l;
        getApp().globalData.user_press_h = res.data.json[0].user_press_h;
        getApp().globalData.user_rate = res.data.json[0].user_rate;
        getApp().globalData.tem_time = res.data.json[0].tem_time;
        getApp().globalData.rate_time = res.data.json[0].rate_time;
        getApp().globalData.press_time = res.data.json[0].press_time;
        getApp().globalData.relation = res.data.relation;
        getApp().globalData.json = res.data.json;
        getApp().globalData.index = '0';
        getApp().globalData.phone = res.data.phone;
        getApp().globalData.bimg = res.data.json[0].bimg;
        console.log(getApp().globalData.map);
        if (getApp().globalData.headimg != null || getApp().globalData.map != null){
          wx.request({
            url: 'https://www.zyserverfordevelop.cn/healthcloud/user/setinfo.do',
            data: {
              id: getApp().globalData.id,
              img: getApp().globalData.headimg,
              map: getApp().globalData.map
            },
          })
        }
       

        wx.switchTab({
          url: '../homepage/homepage'
        })
        

      },
      fail: function (res) {
        console.log(res.data);
        console.log('is failed')
      }
    })
  },
})
