Page({
  data: {
  },
  onLoad: function () {
  },

  login: function () {   
    wx.navigateTo({
      url: '../login/login',
      success: function(res) {},
      fail: function(res) {},
      complete: function(res) {},
    })
  },  
  eval: function () {
    wx.navigateTo({
      url: '../statistics/statistics',
      success: function (res) { },
      fail: function (res) { },
      complete: function (res) { },
    })
  }  
})
