var all = getApp().globalData;

Page({

  /**
   * 页面的初始数据
   */
  data: {
  
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  
  },

  evaluate:function(){
    if (all.id != null){
      if (all.id == all.user_id){
        wx.request({
          url: 'https://www.zyserverfordevelop.cn/healthcloud/eval/evaluate.do',
          data: {
            id: all.id,
            user_tem: all.user_tem,
            user_press_l: all.user_press_l,
            user_press_h: all.user_press_h,
            user_rate: all.user_rate,
            map: all.map,
            sex: all.sex
          },
          success: function (res) {
            getApp().globalData.score = res.data.score;
            getApp().globalData.time = res.data.time;
            getApp().globalData.user_tem = res.data.user_tem;
            getApp().globalData.user_press_l = res.data.user_press_l;
            getApp().globalData.user_press_h = res.data.user_press_h;
            getApp().globalData.user_rate = res.data.user_rate;
            getApp().globalData.tem_describe = res.data.tem_describe;
            getApp().globalData.rate_describe = res.data.rate_describe;
            getApp().globalData.press_describe = res.data.press_describe;

            //发短信业务给家长
            wx.request({
              url: 'https://www.zyserverfordevelop.cn/healthcloud/eval/sendSms.do',
              data: {
                tem: res.data.user_tem,
                rate: res.data.user_rate,
                press_l: res.data.user_press_l,
                press_h: res.data.user_press_h,
                score: res.data.score,
                user_id: all.user_id,
                phone: all.phone
              }
            })
          }
        })

       

        wx.navigateTo({
          url: '../evaluate/report/report',
        })

      }else{
        wx.navigateTo({
          url: '../evalistbyfam/evalistbyfam',
        })
      }
    }
  }
})