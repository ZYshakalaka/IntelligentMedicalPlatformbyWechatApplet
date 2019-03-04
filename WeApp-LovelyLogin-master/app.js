App({
  data: {
    id: '',
    pwd: '',
    user_id:'',
    tem:'',
    user_tem:'',
    user_press_l:'',
    user_press_h:'',
    user_rate:'',
    tem_time:'',
    rate_time:'',
    press_time:'',

    score: '',
    tem_describe: '',
    rate_describe: '',
    press_describe: '',
    time: '',

    sex:'',
    map:'',
    headimg:'',

    relation:'',
    json:[],
    index:'',
    phone:'',
    
    th: '',
    tl: '',
    jsont_hS:'',
    jsont_lS: '',
    jsonr_hS: '',
    jsonr_lS: '',
    jsonp_hS: '',
    jsonp_lS: '',
    jsonr_h: [],
    jsonr_l: [],
    jsonp_h: [],
    jsonp_l: [],
    jsont_h: [],
    jsont_l: [],
    bimg:''
  },
  onLaunch() {
  },
  globalData:{
    wxUserInfo:null,
    id:null,
    pwd:null
  }
  
})
