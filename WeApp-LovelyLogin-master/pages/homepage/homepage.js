var all = getApp().globalData;
Page({
  data: {
    user_id: '',
    tem: '',
    user_tem: '',
    user_press_l: '',
    user_press_h: '',
    user_rate: '',
    tem_time:'',
    press_time:'',
    rate_time:'',
    id:'',
    pwd:'',
    headimg:'',
    array: [],
    index:0,
    bimg:'',
  },
  bindPickerChange: function (e) {
    console.log('picker发送选择改变，携带值为', e.detail.value)
    all.index = e.detail.value
    this.setData({
      tem: all.json[all.index].tem,
      user_id: all.json[all.index].user_id,
      user_tem: all.json[all.index].user_tem,
      user_press_l: all.json[all.index].user_press_l,
      user_press_h: all.json[all.index].user_press_h,
      user_rate: all.json[all.index].user_rate,
      tem_time: all.json[all.index].tem_time,
      press_time: all.json[all.index].press_time,
      rate_time: all.json[all.index].rate_time,
      bimg: all.json[all.index].bimg,
      id: all.id,
      pwd: all.pwd,
      headimg: all.headimg
    });
  },
  onLoad: function () {
    if(all.id != null){
      console.log('.....');
      var that = this;
      if(all.relation == 0){
        wx.request({
          url: 'https://www.zyserverfordevelop.cn/healthcloud/user/changeid.do',
          data: {
            id: all.id,
          },
          method: 'GET',
          success: function (res) {
            that.setData({
            array: res.data
            })
          },
        })
          
      }else{
        var data = new Array();
        data[0] = all.id;
        that.setData({
          array: data
        })
      }
        
      that.setData({
        tem: all.json[all.index].tem,
        user_id: all.json[all.index].user_id,
        user_tem: all.json[all.index].user_tem,
        user_press_l: all.json[all.index].user_press_l,
        user_press_h: all.json[all.index].user_press_h,
        user_rate: all.json[all.index].user_rate,
        tem_time: all.json[all.index].tem_time,
        press_time: all.json[all.index].press_time,
        rate_time: all.json[all.index].rate_time,
        id: all.id,
        pwd: all.pwd,
        headimg: all.headimg,
        bimg: all.json[all.index].bimg
       });
    }else{

    }
  },
  
  jumpt: function () {     
    var that = this
    wx.request({
      url: 'https://www.zyserverfordevelop.cn/healthcloud/tem/caltemforday.do',
      data: {
        user_id: this.data.user_id,
      },
      method: 'GET',
      success: function (res) {
        wx.redirectTo({
          url: '../homepage/chart/chart?time1=' + res.data.json[0].time + '&time2=' + res.data.json[1].time + 
          '&time3=' + res.data.json[2].time + '&time4=' + res.data.json[3].time + '&time5=' + res.data.json[4].time +
          '&tem1=' + res.data.json[0].tem + '&tem2=' + res.data.json[1].tem + '&tem3=' +
          res.data.json[2].tem + '&tem4=' + res.data.json[3].tem + '&tem5=' + res.data.json[4].tem
        })
      },
      fail: function (res) {
        console.log(res.data);
        console.log('is failed')
      }
    })
  },
  jumput: function () {
    var that = this
    wx.request({
      url: 'https://www.zyserverfordevelop.cn/healthcloud/tem/calutemforday.do',
      data: {
        user_id: this.data.user_id,
      },
      method: 'GET',
      success: function (res) {
        wx.redirectTo({
          url: '../homepage/charutem/charutem?time1=' + res.data.json[0].time + '&time2=' + res.data.json[1].time +
          '&time3=' + res.data.json[2].time + '&time4=' + res.data.json[3].time + '&time5=' + res.data.json[4].time +
          '&tem1=' + res.data.json[0].tem + '&tem2=' + res.data.json[1].tem + '&tem3=' +
          res.data.json[2].tem + '&tem4=' + res.data.json[3].tem + '&tem5=' + res.data.json[4].tem
        })
      },
      fail: function (res) {
        console.log(res.data);
        console.log('is failed')
      }
    })
  },
  jumpr: function () {
    var that = this
    wx.request({
      url: 'https://www.zyserverfordevelop.cn/healthcloud/rate/calrateforday.do',
      data: {
        user_id: this.data.user_id,
      },
      method: 'GET',
      success: function (res) {
        wx.redirectTo({
          url: '../homepage/charrate/charrate?time1=' + res.data.json[0].time + '&time2=' + res.data.json[1].time +
          '&time3=' + res.data.json[2].time + '&time4=' + res.data.json[3].time + '&time5=' + res.data.json[4].time +
          '&rate1=' + res.data.json[0].rate + '&rate2=' + res.data.json[1].rate + '&rate3=' +
          res.data.json[2].rate + '&rate4=' + res.data.json[3].rate + '&rate5=' + res.data.json[4].rate
        })
      },
      fail: function (res) {
        console.log(res.data);
        console.log('is failed')
      }
    })
  },
  jumpp: function () {
    var that = this
    wx.request({
      url: 'https://www.zyserverfordevelop.cn/healthcloud/press/calpressforday.do',
      data: {
        user_id: this.data.user_id,
      },
      method: 'GET',
      success: function (res) {
        console.log(res.data.json[0].time);
        wx.redirectTo({
          url: '../homepage/charpress/charpress?time1=' + res.data.json[0].time + '&time2=' + res.data.json[1].time +
          '&time3=' + res.data.json[2].time + '&time4=' + res.data.json[3].time + '&time5=' + res.data.json[4].time +
          '&user_press_l1=' + res.data.json[0].user_press_l + '&user_press_l2=' + res.data.json[1].user_press_l + '&user_press_l3=' +
          res.data.json[2].user_press_l + '&user_press_l4=' + res.data.json[3].user_press_l + '&user_press_l5=' + res.data.json[4].user_press_l
          + '&user_press_h1=' + res.data.json[0].user_press_h + '&user_press_h2=' + res.data.json[1].user_press_h + '&user_press_h3=' +
          res.data.json[2].user_press_h + '&user_press_h4=' + res.data.json[3].user_press_h + '&user_press_h5=' + res.data.json[4].user_press_h
        })
      },
      fail: function (res) {
        console.log(res.data);
        console.log('is failed')
      }
    })
  },
  onPullDownRefresh() {
    　　console.log('--------下拉刷新-------')
    　　wx.showNavigationBarLoading() //在标题栏中显示加载
       var that = this
    　　wx.request({
           url: 'https://www.zyserverfordevelop.cn/healthcloud/user/login.do',
           data: {
             id:getApp().globalData.id,
             pwd:getApp().globalData.pwd
          },
           method: 'GET',
           success: function (res) {
             getApp().globalData.tem = res.data.json[0].tem;
             getApp().globalData.user_tem = res.data.json[0].user_tem;
             getApp().globalData.user_press_l = res.data.json[0].user_press_l;
             getApp().globalData.user_press_h = res.data.json[0].user_press_h;
             getApp().globalData.user_rate = res.data.json[0].user_rate;
             getApp().globalData.tem_time = res.data.json[0].tem_time;
             getApp().globalData.rate_time = res.data.json[0].rate_time;
             getApp().globalData.press_time = res.data.json[0].press_time;
             wx.switchTab({
               url: '../homepage/homepage'
             })
           },
           fail: function () {
              // fail
           },
           complete: function () {
              // complete
              wx.hideNavigationBarLoading() //完成停止加载
              wx.stopPullDownRefresh() //停止下拉刷新
           }
      })
  },
  openAlert: function () {
    wx.showModal({
      content: '弹窗内容，告知当前状态、信息和解决方法，描述文字尽量控制在三行内',
      showCancel: false,
      success: function (res) {
        if (res.confirm) {
          console.log('用户点击确定')
        }
      }
    });
  },

  onUnload: function () {
      console.log('onload');
  },
})
