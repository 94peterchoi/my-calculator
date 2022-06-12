package calc.service;

public class ConverterFactory {

    // 후위연산 변환기 생성
    public static Converter createPostfixConverter() {
        return new PostfixConverter();
    }

    // 중위연산 변환기 생성
//    public static Converter createInfixConverter() {
//        return new InfixConverter();
//    }

}
