#pragma once
#include <jni.h>

static float S21U_ISO120[4][13][17] = {
        {
                {3.9921875f, 2.8828125f, 2.390625f, 2.1621094f, 1.9804688f, 1.8476562f, 1.7519531f, 1.6914062f, 1.6748047f, 1.6962891f, 1.7558594f, 1.8466797f, 1.9726562f, 2.1601562f, 2.415039f, 2.9404297f, 4.114258f},
                {3.0791016f, 2.4707031f, 2.1865234f, 1.9755859f, 1.8095703f, 1.6669922f, 1.5576172f, 1.4863281f, 1.4648438f, 1.4882812f, 1.5566406f, 1.6669922f, 1.8066406f, 1.9716797f, 2.1933594f, 2.5f, 3.1484375f},
                {2.602539f, 2.2675781f, 2.0117188f, 1.8115234f, 1.6279297f, 1.4697266f, 1.3681641f, 1.3144531f, 1.3037109f, 1.3203125f, 1.3701172f, 1.4726562f, 1.6279297f, 1.8046875f, 1.9990234f, 2.274414f, 2.6523438f},
                {2.375f, 2.1132812f, 1.8798828f, 1.6689453f, 1.4716797f, 1.3417969f, 1.2568359f, 1.1982422f, 1.1767578f, 1.203125f, 1.2617188f, 1.3388672f, 1.4677734f, 1.6621094f, 1.8691406f, 2.1142578f, 2.4316406f},
                {2.2695312f, 2.0019531f, 1.7734375f, 1.5478516f, 1.3681641f, 1.2568359f, 1.1621094f, 1.0957031f, 1.0751953f, 1.0976562f, 1.1601562f, 1.25f, 1.3603516f, 1.5439453f, 1.7646484f, 2.0009766f, 2.2871094f},
                {2.209961f, 1.9443359f, 1.7070312f, 1.4707031f, 1.3095703f, 1.1933594f, 1.0947266f, 1.0380859f, 1.0205078f, 1.0400391f, 1.0927734f, 1.1894531f, 1.3046875f, 1.4648438f, 1.703125f, 1.9414062f, 2.2167969f},
                {2.1904297f, 1.9326172f, 1.6845703f, 1.4453125f, 1.2890625f, 1.1660156f, 1.0673828f, 1.0126953f, 1.0f, 1.0185547f, 1.0703125f, 1.1650391f, 1.2851562f, 1.4423828f, 1.6787109f, 1.9111328f, 2.1992188f},
                {2.1992188f, 1.9521484f, 1.7060547f, 1.46875f, 1.3066406f, 1.1875f, 1.0869141f, 1.0322266f, 1.0146484f, 1.0351562f, 1.0869141f, 1.1855469f, 1.3037109f, 1.4667969f, 1.7001953f, 1.9345703f, 2.2177734f},
                {2.2607422f, 2.0107422f, 1.7685547f, 1.5371094f, 1.3583984f, 1.2441406f, 1.1494141f, 1.0888672f, 1.0693359f, 1.0888672f, 1.1503906f, 1.2470703f, 1.3505859f, 1.5341797f, 1.7675781f, 1.9951172f, 2.2851562f},
                {2.3896484f, 2.116211f, 1.8798828f, 1.6542969f, 1.4550781f, 1.3271484f, 1.2490234f, 1.1855469f, 1.1640625f, 1.1875f, 1.2480469f, 1.328125f, 1.4492188f, 1.6494141f, 1.8613281f, 2.0976562f, 2.4082031f},
                {2.555664f, 2.2626953f, 2.0058594f, 1.8056641f, 1.6152344f, 1.4599609f, 1.3564453f, 1.3037109f, 1.2871094f, 1.3066406f, 1.3583984f, 1.4541016f, 1.609375f, 1.796875f, 1.9960938f, 2.2636719f, 2.6142578f},
                {2.8779297f, 2.4355469f, 2.1767578f, 1.9804688f, 1.8095703f, 1.6503906f, 1.5292969f, 1.4599609f, 1.4375f, 1.4560547f, 1.5273438f, 1.6464844f, 1.7939453f, 1.9638672f, 2.1835938f, 2.4833984f, 3.0449219f},
                {3.5585938f, 2.7460938f, 2.3886719f, 2.1523438f, 1.9804688f, 1.84375f, 1.7363281f, 1.6669922f, 1.6455078f, 1.6669922f, 1.7333984f, 1.8369141f, 1.9667969f, 2.1445312f, 2.3925781f, 2.8203125f, 3.790039f}},
        {
                {3.9765625f, 2.9248047f, 2.4570312f, 2.2373047f, 2.0595703f, 1.9130859f, 1.8164062f, 1.7529297f, 1.7314453f, 1.7548828f, 1.8193359f, 1.9150391f, 2.0478516f, 2.2314453f, 2.4726562f, 2.9785156f, 4.114258f},
                {3.1035156f, 2.5273438f, 2.2607422f, 2.0478516f, 1.8740234f, 1.7226562f, 1.6083984f, 1.5322266f, 1.5087891f, 1.5341797f, 1.6074219f, 1.7246094f, 1.8701172f, 2.0371094f, 2.2539062f, 2.5458984f, 3.1728516f},
                {2.6435547f, 2.3310547f, 2.0820312f, 1.8730469f, 1.6796875f, 1.5166016f, 1.40625f, 1.3505859f, 1.3378906f, 1.3574219f, 1.4101562f, 1.5185547f, 1.6806641f, 1.8623047f, 2.0595703f, 2.3271484f, 2.6914062f},
                {2.4296875f, 2.1826172f, 1.9423828f, 1.7216797f, 1.515625f, 1.3798828f, 1.2880859f, 1.2255859f, 1.203125f, 1.2304688f, 1.2939453f, 1.3779297f, 1.5068359f, 1.7158203f, 1.9248047f, 2.165039f, 2.4746094f},
                {2.3232422f, 2.0654297f, 1.8271484f, 1.5927734f, 1.40625f, 1.2871094f, 1.1826172f, 1.1103516f, 1.0888672f, 1.1113281f, 1.1806641f, 1.2783203f, 1.3974609f, 1.5898438f, 1.8164062f, 2.0546875f, 2.3388672f},
                {2.2558594f, 1.9990234f, 1.7529297f, 1.5087891f, 1.3427734f, 1.21875f, 1.1083984f, 1.0449219f, 1.0244141f, 1.0458984f, 1.1044922f, 1.2128906f, 1.3369141f, 1.5048828f, 1.7509766f, 1.9902344f, 2.265625f},
                {2.2314453f, 1.9794922f, 1.7275391f, 1.4794922f, 1.3173828f, 1.1875f, 1.078125f, 1.015625f, 1.0f, 1.0224609f, 1.0820312f, 1.1855469f, 1.3154297f, 1.4785156f, 1.7255859f, 1.9619141f, 2.25f},
                {2.2382812f, 1.9970703f, 1.75f, 1.5019531f, 1.3349609f, 1.2080078f, 1.0966797f, 1.0361328f, 1.0166016f, 1.0400391f, 1.0996094f, 1.2070312f, 1.3339844f, 1.5019531f, 1.7480469f, 1.9873047f, 2.2705078f},
                {2.3066406f, 2.0664062f, 1.8164062f, 1.5742188f, 1.3886719f, 1.2666016f, 1.1660156f, 1.0986328f, 1.078125f, 1.0996094f, 1.1679688f, 1.2724609f, 1.3828125f, 1.5732422f, 1.8183594f, 2.0488281f, 2.3466797f},
                {2.4384766f, 2.1757812f, 1.9296875f, 1.6962891f, 1.4882812f, 1.359375f, 1.2724609f, 1.2070312f, 1.1835938f, 1.2089844f, 1.2753906f, 1.3613281f, 1.4853516f, 1.6962891f, 1.9160156f, 2.1542969f, 2.4707031f},
                {2.5986328f, 2.3242188f, 2.0654297f, 1.8603516f, 1.6640625f, 1.4980469f, 1.3896484f, 1.3339844f, 1.3164062f, 1.3378906f, 1.3916016f, 1.4941406f, 1.6552734f, 1.8505859f, 2.055664f, 2.3271484f, 2.6689453f},
                {2.8984375f, 2.4921875f, 2.2509766f, 2.0478516f, 1.8671875f, 1.6982422f, 1.5722656f, 1.4951172f, 1.4697266f, 1.4931641f, 1.5712891f, 1.6982422f, 1.8525391f, 2.03125f, 2.2558594f, 2.5410156f, 3.0957031f},
                {3.5458984f, 2.7978516f, 2.4648438f, 2.234375f, 2.0517578f, 1.90625f, 1.7929688f, 1.7177734f, 1.6914062f, 1.7197266f, 1.7929688f, 1.9042969f, 2.0439453f, 2.2304688f, 2.46875f, 2.8828125f, 3.8378906f}},
        {
                {3.9921875f, 2.928711f, 2.4521484f, 2.2285156f, 2.0439453f, 1.8994141f, 1.8007812f, 1.7382812f, 1.7177734f, 1.7421875f, 1.8066406f, 1.9042969f, 2.0371094f, 2.225586f, 2.4707031f, 2.977539f, 4.1171875f},
                {3.116211f, 2.5263672f, 2.2578125f, 2.0410156f, 1.8642578f, 1.7138672f, 1.5986328f, 1.5224609f, 1.5009766f, 1.5273438f, 1.5986328f, 1.7148438f, 1.8642578f, 2.03125f, 2.2519531f, 2.546875f, 3.1728516f},
                {2.6552734f, 2.3388672f, 2.0859375f, 1.8730469f, 1.6787109f, 1.5097656f, 1.4003906f, 1.3447266f, 1.3339844f, 1.3515625f, 1.4052734f, 1.5146484f, 1.6796875f, 1.8632812f, 2.0615234f, 2.3359375f, 2.6982422f},
                {2.4453125f, 2.194336f, 1.9501953f, 1.7246094f, 1.515625f, 1.3779297f, 1.2841797f, 1.2226562f, 1.1992188f, 1.2275391f, 1.2910156f, 1.375f, 1.5068359f, 1.71875f, 1.9277344f, 2.1738281f, 2.4892578f},
                {2.3398438f, 2.078125f, 1.8359375f, 1.5957031f, 1.4082031f, 1.2871094f, 1.1816406f, 1.109375f, 1.0878906f, 1.1103516f, 1.1787109f, 1.2773438f, 1.3974609f, 1.5917969f, 1.8232422f, 2.0644531f, 2.352539f},
                {2.2773438f, 2.015625f, 1.7646484f, 1.515625f, 1.3447266f, 1.21875f, 1.1074219f, 1.0429688f, 1.0244141f, 1.0449219f, 1.1035156f, 1.2138672f, 1.3378906f, 1.5078125f, 1.7578125f, 2.0009766f, 2.2822266f},
                {2.25f, 1.9931641f, 1.7373047f, 1.4853516f, 1.3203125f, 1.1884766f, 1.078125f, 1.015625f, 1.0f, 1.0214844f, 1.0800781f, 1.1845703f, 1.3164062f, 1.4814453f, 1.7304688f, 1.9736328f, 2.2675781f},
                {2.2617188f, 2.0146484f, 1.7626953f, 1.5097656f, 1.3388672f, 1.2099609f, 1.0966797f, 1.0361328f, 1.0175781f, 1.0390625f, 1.0986328f, 1.2060547f, 1.3359375f, 1.5058594f, 1.7548828f, 2.0009766f, 2.2861328f},
                {2.3320312f, 2.0839844f, 1.8300781f, 1.5830078f, 1.3945312f, 1.2695312f, 1.1679688f, 1.1005859f, 1.0791016f, 1.0996094f, 1.1669922f, 1.2734375f, 1.3847656f, 1.578125f, 1.8261719f, 2.0615234f, 2.359375f},
                {2.461914f, 2.1953125f, 1.9433594f, 1.7060547f, 1.4941406f, 1.3623047f, 1.2734375f, 1.2080078f, 1.1835938f, 1.2089844f, 1.2744141f, 1.3603516f, 1.4863281f, 1.7001953f, 1.9228516f, 2.1640625f, 2.4824219f},
                {2.625f, 2.3417969f, 2.078125f, 1.8710938f, 1.6679688f, 1.5f, 1.3896484f, 1.3339844f, 1.3164062f, 1.3359375f, 1.3896484f, 1.4931641f, 1.6552734f, 1.8535156f, 2.0625f, 2.3330078f, 2.6777344f},
                {2.9189453f, 2.5097656f, 2.2607422f, 2.055664f, 1.8691406f, 1.6982422f, 1.5703125f, 1.4931641f, 1.4677734f, 1.4902344f, 1.5673828f, 1.6943359f, 1.8496094f, 2.03125f, 2.2558594f, 2.5458984f, 3.0947266f},
                {3.5664062f, 2.8085938f, 2.4707031f, 2.2373047f, 2.0517578f, 1.9013672f, 1.7861328f, 1.7119141f, 1.6845703f, 1.7109375f, 1.7841797f, 1.8964844f, 2.0371094f, 2.2246094f, 2.4697266f, 2.8828125f, 3.8408203f}},
        {
                {3.6826172f, 2.711914f, 2.3007812f, 2.1132812f, 1.9609375f, 1.8339844f, 1.7509766f, 1.6943359f, 1.6787109f, 1.7021484f, 1.7597656f, 1.8486328f, 1.9658203f, 2.125f, 2.3300781f, 2.7822266f, 3.821289f},
                {2.9003906f, 2.3769531f, 2.1464844f, 1.9609375f, 1.8007812f, 1.6650391f, 1.5615234f, 1.4931641f, 1.4736328f, 1.4980469f, 1.5654297f, 1.6748047f, 1.8125f, 1.96875f, 2.1572266f, 2.4169922f, 2.9794922f},
                {2.4921875f, 2.2216797f, 1.9990234f, 1.8066406f, 1.6269531f, 1.4726562f, 1.3740234f, 1.3242188f, 1.3154297f, 1.3330078f, 1.3818359f, 1.4833984f, 1.6386719f, 1.8134766f, 2.0f, 2.2402344f, 2.553711f},
                {2.3144531f, 2.1064453f, 1.8857422f, 1.671875f, 1.4755859f, 1.3476562f, 1.2617188f, 1.2070312f, 1.1875f, 1.2138672f, 1.2724609f, 1.3554688f, 1.4804688f, 1.6806641f, 1.8847656f, 2.102539f, 2.383789f},
                {2.2451172f, 2.0136719f, 1.7851562f, 1.5566406f, 1.3779297f, 1.2617188f, 1.1630859f, 1.0976562f, 1.0791016f, 1.0996094f, 1.1669922f, 1.2646484f, 1.3818359f, 1.5664062f, 1.7919922f, 2.015625f, 2.2851562f},
                {2.196289f, 1.9619141f, 1.7216797f, 1.4833984f, 1.3222656f, 1.2001953f, 1.0947266f, 1.0371094f, 1.0185547f, 1.0410156f, 1.0986328f, 1.2060547f, 1.3251953f, 1.4902344f, 1.7324219f, 1.9707031f, 2.2265625f},
                {2.1738281f, 1.9404297f, 1.6982422f, 1.4589844f, 1.3007812f, 1.1738281f, 1.0683594f, 1.0117188f, 1.0f, 1.0214844f, 1.078125f, 1.1806641f, 1.3085938f, 1.4667969f, 1.7080078f, 1.9414062f, 2.2089844f},
                {2.1796875f, 1.9599609f, 1.7197266f, 1.4804688f, 1.3164062f, 1.1933594f, 1.0859375f, 1.03125f, 1.015625f, 1.0361328f, 1.0927734f, 1.2011719f, 1.3271484f, 1.4902344f, 1.7304688f, 1.9648438f, 2.2285156f},
                {2.2392578f, 2.0195312f, 1.7832031f, 1.546875f, 1.3652344f, 1.2470703f, 1.1523438f, 1.0898438f, 1.0712891f, 1.0908203f, 1.1572266f, 1.2617188f, 1.3710938f, 1.5576172f, 1.7988281f, 2.022461f, 2.2949219f},
                {2.336914f, 2.1113281f, 1.8837891f, 1.6552734f, 1.4580078f, 1.3349609f, 1.2509766f, 1.1933594f, 1.1738281f, 1.1992188f, 1.2587891f, 1.3427734f, 1.4658203f, 1.6708984f, 1.8867188f, 2.109375f, 2.3935547f},
                {2.4677734f, 2.2324219f, 1.9980469f, 1.8115234f, 1.6240234f, 1.4648438f, 1.3662109f, 1.3173828f, 1.3017578f, 1.3232422f, 1.3720703f, 1.4707031f, 1.6259766f, 1.8144531f, 2.0097656f, 2.2509766f, 2.5488281f},
                {2.7207031f, 2.366211f, 2.1552734f, 1.9765625f, 1.8154297f, 1.6572266f, 1.5429688f, 1.4726562f, 1.4501953f, 1.4726562f, 1.5429688f, 1.6621094f, 1.8085938f, 1.9746094f, 2.1757812f, 2.4296875f, 2.9199219f},
                {3.2919922f, 2.6171875f, 2.3320312f, 2.1367188f, 1.9833984f, 1.8554688f, 1.7519531f, 1.6865234f, 1.6611328f, 1.6875f, 1.7558594f, 1.8574219f, 1.9833984f, 2.1445312f, 2.3554688f, 2.71875f, 3.5976562f}}
};